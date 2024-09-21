package com.toGames.b2bStrength.controllers.trainers;

import com.toGames.b2bStrength.dtos.clients.RegisterClientDTO;
import com.toGames.b2bStrength.dtos.trainers.TrainerInfoInDTO;
import com.toGames.b2bStrength.services.trainers.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1.0/trainers")
public class TrainerController {

    @Autowired
    TrainerService trainerService;

    @PostMapping
    public ResponseEntity<Object> registerNewTrainer(@Validated @ModelAttribute TrainerInfoInDTO registerTrainerInDTO){
        return new ResponseEntity<>(trainerService.registerNewTrainer(registerTrainerInDTO), HttpStatus.OK);
    }



}
