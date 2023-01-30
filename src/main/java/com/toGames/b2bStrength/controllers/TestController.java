package com.toGames.b2bStrength.controllers;

import com.toGames.b2bStrength.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/api/test")
    public ResponseEntity<Object> testClientAndTrainersRepo(){


        return new ResponseEntity<>(testService.createTestClientAndTrainer(), HttpStatus.ACCEPTED);
    }


}
