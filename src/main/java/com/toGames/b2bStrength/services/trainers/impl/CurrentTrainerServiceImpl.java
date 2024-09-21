package com.toGames.b2bStrength.services.trainers.impl;

import com.toGames.b2bStrength.dtos.clients.AvatarInDto;
import com.toGames.b2bStrength.dtos.routines.*;
import com.toGames.b2bStrength.dtos.trainers.TrainerBasicInfoOutDTO;
import com.toGames.b2bStrength.models.clients.Client;
import com.toGames.b2bStrength.models.routines.*;
import com.toGames.b2bStrength.models.trainers.Trainer;
import com.toGames.b2bStrength.models.trainings.Training;
import com.toGames.b2bStrength.repositories.clients.ClientRepository;
import com.toGames.b2bStrength.repositories.routines.*;
import com.toGames.b2bStrength.repositories.trainers.TrainerRepository;
import com.toGames.b2bStrength.repositories.trainings.TrainingRepository;
import com.toGames.b2bStrength.services.clients.ClientService;
import com.toGames.b2bStrength.services.trainers.CurrentTrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static com.toGames.b2bStrength.utils.Constant.*;

@Service
public class CurrentTrainerServiceImpl implements CurrentTrainerService {
    @Autowired
    ActivityRepository activityRepository;
    @Autowired
    ActivityTypeRepository activityTypeRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    DailyRepository dailyRepository;
    @Autowired
    RoutineRepository routineRepository;
    @Autowired
    TrainerRepository trainerRepository;
    @Autowired
    TrainerClientRelationRepository trainerClientRelationRepository;

    @Autowired
    TrainerClientRelationStatusRepository trainerClientRelationStatusRepository;
    @Autowired
    TrainingRepository trainingRepository;
    @Autowired
    ClientService clientService;
    @Autowired
    HttpSession session;

    @Override
    public Set<TrainerClientRelationOutDTO> getTrainerClientRelationsByStatus(long statusId) {
        if(statusId!=0)
        {
            Set<TrainerClientRelationOutDTO> trainerClientRelationOutDTOS;

            Trainer current = getTrainerInSession();

            Set<TrainerClientRelation> trainerClientRelations = trainerClientRelationRepository.findByTrainerIdAndStatusId(current.getId(), statusId);

            trainerClientRelationOutDTOS = trainerClientRelations.stream().map(TrainerClientRelationOutDTO::new).collect(Collectors.toSet());

            return trainerClientRelationOutDTOS;
        }
        else{
            return null;
        }
    }
    @Override
    public Optional<RoutineExtendedInfoOutDTO> newRoutine(NewRoutineInDTO routineIn) {
        //primero hay que comprobar que el cliente y el entrenador tienen una trainer-client relation en común. Si es así
        Trainer current = getTrainerInSession();

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


        TrainerClientRelationStatus tcr = trainerClientRelationStatusRepository.findById(TCR_STATUS_ACCEPTED).orElse(null);

        if(tcr!=null){
            tcr.addTrainerClientRelation(actualTcr);
        }

        newRoutine = routineRepository.save(newRoutine);

        clientService.updateClientStatus(currentClient, CLIENT_STATUS_HAS_ROUTINE);

        RoutineExtendedInfoOutDTO routineExtendedInfoOutDTO = new RoutineExtendedInfoOutDTO(newRoutine);

        return Optional.of(routineExtendedInfoOutDTO);
    }

    @Override
    public Object updateTrainerAvatar(AvatarInDto avatarInDto) {
        String avatar = String.valueOf(avatarInDto.getId());
        Trainer trainerInSession = getTrainerInSession();

        trainerInSession.setIcon(avatar);

        trainerRepository.save(trainerInSession);

        return Optional.empty();
    }

    @Override
    public Optional<TrainerBasicInfoOutDTO> getCurrentTrainer() {
        Trainer currentTrainer = getTrainerInSession();

        return Optional.of(new TrainerBasicInfoOutDTO(currentTrainer));
    }

    public Trainer getTrainerInSession(){
        Long trainerId = 0L;
        try{
            trainerId = Long.parseLong(session.getAttribute(SESSION_ATTR_USER_ID).toString());
        }
        catch (Exception e){
            throw new RuntimeException("Error en el parseo, con el id: " + session.getAttribute(SESSION_ATTR_USER_ID)  );
        }

        Trainer current = trainerRepository.findById(trainerId).orElse(null);

        if(current==null){
            throw new RuntimeException("El entrenador es nulo");
        }

//        if(current.getStatus().getId() < requiredStatus){
//            throw new RuntimeException("el usuario no tiene status para esta peticion ");
//        } acá se popdría hacer un equivalente con el nivel de acceso del entrenador

        return current;
    }
}
