package com.toGames.b2bStrength.services.routines.impl;

import com.toGames.b2bStrength.dtos.routines.NewActivityInDTO;
import com.toGames.b2bStrength.dtos.routines.NewDailyInDTO;
import com.toGames.b2bStrength.dtos.routines.NewRoutineInDTO;
import com.toGames.b2bStrength.dtos.routines.RoutineExtendedInfoOutDTO;
import com.toGames.b2bStrength.models.clients.Client;
import com.toGames.b2bStrength.models.routines.*;
import com.toGames.b2bStrength.models.trainers.Trainer;
import com.toGames.b2bStrength.models.trainings.Training;
import com.toGames.b2bStrength.repositories.clients.ClientRepository;
import com.toGames.b2bStrength.repositories.routines.*;
import com.toGames.b2bStrength.repositories.trainings.TrainingRepository;
import com.toGames.b2bStrength.services.clients.ClientService;
import com.toGames.b2bStrength.services.routines.RoutineService;
import com.toGames.b2bStrength.services.trainers.CurrentTrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

import static com.toGames.b2bStrength.utils.Constant.CLIENT_STATUS_HAS_ROUTINE;
import static com.toGames.b2bStrength.utils.Constant.TCR_STATUS_ACCEPTED;

@Service
public class RoutineServiceImpl implements RoutineService {


    @Autowired
    CurrentTrainerService currentTrainerService;
    @Autowired
    ClientService clientService;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    RoutineRepository routineRepository;
    @Autowired
    DailyRepository dailyRepository;
    @Autowired
    ActivityRepository activityRepository;
    @Autowired
    ActivityTypeRepository activityTypeRepository;
    @Autowired
    TrainerClientRelationRepository trainerClientRelationRepository;
    @Autowired
    TrainerClientRelationStatusRepository trainerClientRelationStatusRepository;
    @Autowired
    TrainingRepository trainingRepository;

    @Override
    public Optional<RoutineExtendedInfoOutDTO> getRoutineById(long id) {
        currentTrainerService.getCurrentTrainer();

        Routine obtainedRoutine = routineRepository.findById(id).orElse(null);

        if(obtainedRoutine!=null){
            return Optional.of(new RoutineExtendedInfoOutDTO(obtainedRoutine));
        }

        return Optional.empty();
    }

    @Override
    public Optional<RoutineExtendedInfoOutDTO> newRoutine(NewRoutineInDTO routineIn) {
        Trainer current = currentTrainerService.getTrainerInSession();

        TrainerClientRelation actualTcr = trainerClientRelationRepository.findById(routineIn.getTrainerClientRelationId()).orElse(null);

        Client currentClient = clientRepository.findById(routineIn.getClientId()).orElse(null);

        if(actualTcr==null){
            throw new RuntimeException("La tcr no existe");
        }

        if(currentClient==null){
            throw new RuntimeException("The client does not exist!");
        }

        LocalDate date = LocalDate.parse(routineIn.getStartDate());

        Routine newRoutine = new Routine(routineIn.getNumOfDays(), date);

        routineRepository.save(newRoutine);
        actualTcr.setRoutine(newRoutine);

        for (NewDailyInDTO dailyIn:
                routineIn.getDailyActivities()) {

            LocalDate dailyDay = LocalDate.parse(dailyIn.getProposedDate());
            Daily newDaily = new Daily(dailyIn.getDayNumber(), dailyDay);
            dailyRepository.save(newDaily); // prueba 2

            for (NewActivityInDTO activityIn :
                    dailyIn.getActivities()) {
                //Obtenermos el training
                Training obtainedTraining = trainingRepository.findById(activityIn.getTrainingId()).orElse(null);
                //Obtenemos el id del tipo de valor
                ActivityType obtainedActivityType = activityTypeRepository.findById(activityIn.getActTypeId()).orElse(null);

                if(obtainedTraining == null|| obtainedActivityType == null){
                    throw new RuntimeException("El entrenamiento o el tipo de actividad es nula");
                }

                Activity newActivity = new Activity(activityIn.getOrderNumber(), obtainedActivityType, activityIn.getActTypeValue());
                activityRepository.save(newActivity);
                newDaily.addActivity(newActivity);
                obtainedTraining.addActivity(newActivity);
            }
            //dailyRepository.save(newDaily); //prueba 1
            newRoutine.addDailyActivities(newDaily);
        }


        trainerClientRelationStatusRepository.findById(TCR_STATUS_ACCEPTED).ifPresent(tcr -> tcr.addTrainerClientRelation(actualTcr));

        routineRepository.save(newRoutine);

        clientService.updateClientStatus(currentClient, CLIENT_STATUS_HAS_ROUTINE);

        return Optional.empty();
    }
}
