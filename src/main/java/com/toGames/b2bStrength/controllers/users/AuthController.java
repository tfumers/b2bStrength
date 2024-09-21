package com.toGames.b2bStrength.controllers.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1.0/auth")
public class AuthController {

    @GetMapping("/success")
    public ResponseEntity<Object> getUserInfo(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/failure")
    public ResponseEntity<Object> getFailureMessage(){
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @GetMapping("/processing")
    public ResponseEntity<Object> getProcessingMessage(){
        return new ResponseEntity<>(HttpStatus.PROCESSING);
    }

}
