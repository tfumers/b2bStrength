package com.toGames.b2bStrength.controllers.trainers;

import com.toGames.b2bStrength.dtos.clients.AvatarInDto;
import com.toGames.b2bStrength.dtos.routines.NewRoutineInDTO;
import com.toGames.b2bStrength.services.trainers.CurrentTrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1.0/trainers/current")
public class CurrentTrainerController {

    @Autowired
    CurrentTrainerService currentTrainerService;

    @GetMapping
    public ResponseEntity<Object> getCurrentTrainer(){
        return new ResponseEntity<>(currentTrainerService.getCurrentTrainer(),HttpStatus.OK);
    }

    @GetMapping(path = "/trainerClientRelations/status/{id}")
    public ResponseEntity<Object> getTrainerClientRelationsByStatus(@PathVariable long id){
        return new ResponseEntity<>(currentTrainerService.getTrainerClientRelationsByStatus(id),HttpStatus.OK);
    }

    @PostMapping(path = "/newRoutine")
    public ResponseEntity<Object> postNewTrainerClientRelation(@Valid @ModelAttribute NewRoutineInDTO routineIn){
        return new ResponseEntity<>(currentTrainerService.newRoutine(routineIn), HttpStatus.OK);
    }

    @PostMapping(path = "/avatar")
    public ResponseEntity<Object> updateAvatar(@Validated @ModelAttribute AvatarInDto avatarInDto){
        return new ResponseEntity<>(currentTrainerService.updateTrainerAvatar(avatarInDto), HttpStatus.OK);
    }

}
