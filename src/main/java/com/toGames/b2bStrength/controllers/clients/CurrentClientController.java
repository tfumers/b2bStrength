package com.toGames.b2bStrength.controllers.clients;

import com.toGames.b2bStrength.dtos.clients.SurveyInfoInDTO;
import com.toGames.b2bStrength.dtos.routines.CompletedDailyActivitiesInDTO;
import com.toGames.b2bStrength.dtos.routines.DailyCompletedInDTO;
import com.toGames.b2bStrength.dtos.routines.TrainerClientRelationInDTO;
import com.toGames.b2bStrength.dtos.trainings.TrainingsInDTO;
import com.toGames.b2bStrength.dtos.users.LoginInfoInDTO;
import com.toGames.b2bStrength.dtos.clients.AvatarInDto;
import com.toGames.b2bStrength.services.clients.CurrentClientService;
import com.toGames.b2bStrength.services.trainings.TrainingService;
import com.toGames.b2bStrength.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1.0/clients/current")
public class CurrentClientController {
    @Autowired
    CurrentClientService currentClientService;

    @Autowired
    TrainingService trainingService;

    @Autowired
    UserService userService;


    @PostMapping(path = "/surveyInfo")
    public ResponseEntity<Object> updateClientSurveyInfo(@Validated @ModelAttribute SurveyInfoInDTO surveyInfoInDTO){
        return new ResponseEntity<>(currentClientService.updateClientSurveyInfo(surveyInfoInDTO), HttpStatus.OK);
    }

    @PostMapping(path = "/avatar")
    public ResponseEntity<Object> updateAvatar(@Validated @ModelAttribute AvatarInDto avatarInDto){
        return new ResponseEntity<>(currentClientService.updateClientAvatar(avatarInDto), HttpStatus.OK);
    }

    @PostMapping(path = "/loginInfo")
    public ResponseEntity<Object> updateClientLoginInfo(@Validated @ModelAttribute LoginInfoInDTO loginInfoInDTO){
        return new ResponseEntity<>(userService.updateUserLoginInfo(loginInfoInDTO), HttpStatus.OK);
    }

    @PostMapping(path = "/newRelation")
    public ResponseEntity<Object> createNewTrainerClientRelation(@Validated @ModelAttribute TrainerClientRelationInDTO newTrainerClientRelationDTO){
        return new ResponseEntity<>(currentClientService.newTrainerClientRelation(newTrainerClientRelationDTO), HttpStatus.OK);
    }

    @PostMapping(path = "/trainings")
    public ResponseEntity<Object> postTrainingIdAndReturnTrainings(@Validated @ModelAttribute TrainingsInDTO trainingIds){
        return new ResponseEntity<>(trainingService.getTrainingsById(trainingIds), HttpStatus.OK);
    }

    @PostMapping(path = "/routines/daily")
    public ResponseEntity<Object> updateCompletedDailyActivities(@Validated @ModelAttribute DailyCompletedInDTO dailyCompletedInDTO){
        return new ResponseEntity<>(currentClientService.updateDailyActivities(dailyCompletedInDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object> getCurrentClient(){
        return new ResponseEntity<>(currentClientService.getCurrentClientInfo(), HttpStatus.OK);
    }

    @GetMapping(path = "/routines")
    public ResponseEntity<Object> getClientRoutines(){
        return new ResponseEntity<>(currentClientService.getRoutines(0L), HttpStatus.OK);
    }

    //Get, para obtener info de los entrenadores
    @GetMapping(path = "/availableTrainers")
    public ResponseEntity<Object> getTrainersInfo(){
        return new ResponseEntity<>(currentClientService.getTrainersInfo(), HttpStatus.OK);
    }

    @GetMapping(path = "/selectedTrainer")
    public ResponseEntity<Object> getSelectedTrainerInfo(){
        return new ResponseEntity<>(currentClientService.getCurrentSelectedTrainer(), HttpStatus.OK);
    }
}
