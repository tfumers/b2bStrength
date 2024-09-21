package com.toGames.b2bStrength.services.clients.impl;

import com.toGames.b2bStrength.models.clients.Client;
import com.toGames.b2bStrength.models.clients.ClientProgress;
import com.toGames.b2bStrength.models.routines.Activity;
import com.toGames.b2bStrength.models.routines.Daily;
import com.toGames.b2bStrength.repositories.clients.ClientProgressRepository;
import com.toGames.b2bStrength.services.clients.ClientProgressService;
import com.toGames.b2bStrength.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientProgressServiceImpl implements ClientProgressService {

    @Autowired
    ClientProgressRepository clientProgressRepository;

    @Override
    public boolean saveClientProgressByCompletedDaily(Client client, Daily daily) {
        ClientProgress clientProgress = clientProgressRepository.findById(client.getId()).orElse(null);

        if(clientProgress==null){
            return false;
        }

        int caloriesBurntToday = 0;
        long timeElapsed = daily.getElapsedTime();
        long trainingRecTime = 0;

        boolean dayCompletedOnProposedDate = (daily.getProposedDate() == daily.getCompletionDate());

        boolean bonusActivityPresent = false;
        int bonusCaloriesBurnt = 0;
        boolean bonusActivityCompleted = false;

        for (Activity act :
                daily.getActivities()) {

            if(act.getType().getId() == Constant.ACTIVITY_TYPE_REPS){
                caloriesBurntToday+= act.getTraining().getEstCaloriesPerRep()*act.getTypeValue();//para multiplicar la cant. de reps. por el bonus
                trainingRecTime += (long) act.getTraining().getEstTimePerRep() *act.getTypeValue();

                if(act.isBonus()){
                    bonusActivityPresent = true;

                    if(act.isCompleted()){
                        bonusCaloriesBurnt += act.getTraining().getEstCaloriesPerRep()*act.getTypeValue();
                        bonusActivityCompleted = true;
                    }
                }
            }
            else{
                caloriesBurntToday+= act.getTraining().getEstCaloriesPerRep();
                trainingRecTime += act.getTypeValue();

                if(act.isBonus()){
                    bonusCaloriesBurnt += act.getTraining().getEstCaloriesPerRep();
                    bonusActivityCompleted = true;
                }
            }
        }

        //Acá se guardan todos los progresos hechos por el usuario

        clientProgress.addCaloriesBurnt(caloriesBurntToday);
        clientProgress.addTimeElapsed(timeElapsed);
        clientProgress.addEstimatedTrainingTime(trainingRecTime);
        clientProgress.addCompletedDay();

        if(dayCompletedOnProposedDate){
            clientProgress.addCompletedOnProposedDay();
        }

        if(bonusActivityPresent){

            clientProgress.addProposedBonusActivity();
            if(bonusActivityCompleted){
                clientProgress.addBonusActivityCompleted();
                clientProgress.addBurntCaloriesOnBonusActivity(bonusCaloriesBurnt);
            }
        }

        clientProgressRepository.save(clientProgress);

        saveClientExp(client, caloriesBurntToday);//le enviamos las calorìas quemadas en el dìa como experiencia

        return true;
    }

    boolean saveClientExp(Client client, int exp) {
        ClientProgress clientProgress = clientProgressRepository.findById(client.getId()).orElse(null);

        if(clientProgress==null){
            return false;
        }

        long clientExp = clientProgress.getExperience() + exp;
        long expDiference = 0;
        long clientLevel = clientProgress.getLevel();
        int extraLevels = 0;

        do{
            long x = clientLevel + extraLevels;

            int requiredExpToNextLevel = (int) ((x+5)*(x*1.5)+75);

            expDiference = requiredExpToNextLevel - clientExp;

            if(expDiference<=0){
                clientExp = -expDiference;
                extraLevels++;
            }
        }while (expDiference<=0);


        if(extraLevels>0){
            clientProgress.addLevels(extraLevels);
            clientProgress.setExperience(clientExp);
        }
        else{
            clientProgress.setExperience(clientExp);
        }

        clientProgress.addTotalExperience(exp);

        clientProgressRepository.save(clientProgress);

        return false;
    }
}
