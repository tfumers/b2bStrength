package com.toGames.b2bStrength.controllers.clients;

import com.toGames.b2bStrength.dtos.clients.RegisterClientDTO;
import com.toGames.b2bStrength.services.clients.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1.0/clients")
public class ClientController {

    @Autowired
    ClientServiceImpl clientService;

    @PostMapping
    public ResponseEntity<Object> registerNewClient(@RequestBody @Validated RegisterClientDTO registerClientDTO){
        return new ResponseEntity<>(clientService.registerNewUser(registerClientDTO), HttpStatus.OK);
    }

    //GET
    public ResponseEntity<Object> getClientsByParams(){
        return new ResponseEntity<>(clientService.getUserByCustomParams(), HttpStatus.OK);
    }

    //PUT
    public ResponseEntity<Object> updateClientInfo(){
        return null;
    }

    //Patch
    public ResponseEntity<Object> updateClientSurveyInfo(){
        return null;
    }

    public ResponseEntity<Object> updateClientLoginInfo(){
        return null;
    }

}
