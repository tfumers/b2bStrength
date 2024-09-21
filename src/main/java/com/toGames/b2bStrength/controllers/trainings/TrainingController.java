package com.toGames.b2bStrength.controllers.trainings;

import com.github.fge.jsonpatch.JsonPatch;
import com.toGames.b2bStrength.dtos.trainings.NewCategoryDTO;
import com.toGames.b2bStrength.dtos.trainings.NewDifficultyDTO;
import com.toGames.b2bStrength.dtos.trainings.NewTrainingDTO;
import com.toGames.b2bStrength.dtos.utils.TrainingSearchParamsDTO;
import com.toGames.b2bStrength.services.trainings.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1.0/trainings")
public class TrainingController {

    @Autowired
    TrainingService trainingService;

//    @PostMapping
//    public ResponseEntity<Object> createNewTraining(@RequestBody NewTrainingDTO){
//        return new ResponseEntity<>(trainingService)
//    }

    //Verbos POST
    @PostMapping
    public ResponseEntity<Object> createNewTraining(@Valid @ModelAttribute NewTrainingDTO newTrainingDTO){
        return new ResponseEntity<>(trainingService.createNewTraining(newTrainingDTO), HttpStatus.CREATED);
    }

    @PostMapping(value = "/category")
    public ResponseEntity<Object> createNewCategory(@RequestBody NewCategoryDTO newCategoryDTO){
        return new ResponseEntity<>(trainingService.createNewCategory(newCategoryDTO), HttpStatus.CREATED);
    }

    @PostMapping(value = "/difficulty")
    public ResponseEntity<Object> createNewDifficulty(@RequestBody NewDifficultyDTO newDifficultyDTO){
        return new ResponseEntity<>(trainingService.createNewDifficulty(newDifficultyDTO), HttpStatus.CREATED);
    }

    //Verbos GET
    @GetMapping("/{id}")
    public ResponseEntity<Object> getTrainingById(@PathVariable Long id){
        return new ResponseEntity<>(trainingService.getTrainingById(id), HttpStatus.ACCEPTED);
    }

    @PostMapping("/search")
    public ResponseEntity<Object> getTrainings(@ModelAttribute TrainingSearchParamsDTO trainingSearchParamsDTO){
        return new ResponseEntity<>(trainingService.getTrainingsByParams(trainingSearchParamsDTO), HttpStatus.OK);
    }

    //Verbos PATCH
    @PatchMapping("/{id}")
    public ResponseEntity<Object> updateExistentTraining(@RequestBody JsonPatch newTrainingPatch, @PathVariable Long id){
        return new ResponseEntity<>(trainingService.updateTraining(newTrainingPatch, id), HttpStatus.CREATED);
    }


    //VERBOS DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTrainingById(@PathVariable Long id){
        return new ResponseEntity<>(trainingService.deleteTrainingById(id), HttpStatus.OK);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<Object> deleteCategoryById(@PathVariable Long id){
        return new ResponseEntity<>(trainingService.deleteCategoryById(id), HttpStatus.OK);
    }

    @DeleteMapping("/difficulty/{id}")
    public ResponseEntity<Object> deleteDifficultyById(@PathVariable Long id){
        return new ResponseEntity<>(trainingService.deleteDifficultyById(id), HttpStatus.OK);
    }


}
