package com.toGames.b2bStrength.controllers.routines;

import com.toGames.b2bStrength.dtos.routines.NewRoutineInDTO;
import com.toGames.b2bStrength.services.routines.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1.0/routines")
public class RoutineController {

    @Autowired
    RoutineService routineService;

    @PostMapping
    public ResponseEntity<Object> newRoutine(NewRoutineInDTO newRoutineInDTO){
        return new ResponseEntity<>(routineService.newRoutine(newRoutineInDTO), HttpStatus.OK);
    }

    @GetMapping(path = "/{routineId}")
    public ResponseEntity<Object> getRoutineById(@PathVariable long routineId){
        return new ResponseEntity<>(routineService.getRoutineById(routineId), HttpStatus.OK);
    }


}
