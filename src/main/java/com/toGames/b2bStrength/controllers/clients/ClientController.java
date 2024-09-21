package com.toGames.b2bStrength.controllers.clients;

import com.toGames.b2bStrength.dtos.clients.RegisterClientDTO;
import com.toGames.b2bStrength.dtos.clients.SurveyInfoInDTO;
import com.toGames.b2bStrength.dtos.users.LoginInfoInDTO;
import com.toGames.b2bStrength.services.clients.impl.ClientServiceImpl;
import com.toGames.b2bStrength.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1.0/clients")
public class ClientController {

    @Autowired
    ClientServiceImpl clientService;

    @PostMapping(path = "/testLogin")//@Validated
    public ResponseEntity<Object> testLoginClient(@Validated @ModelAttribute LoginInfoInDTO loginInfoInDTO){
        return new ResponseEntity<>(clientService.testLoginClient(loginInfoInDTO), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registerNewClient( @Validated @ModelAttribute RegisterClientDTO registerClientDTO){
        return new ResponseEntity<>(clientService.registerNewClient(registerClientDTO), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getClientById(@PathVariable @Validated long id){
        return new ResponseEntity<>(clientService.findClientById(id), HttpStatus.OK);
    }

    //GET
    public ResponseEntity<Object> getClientsByParams(){
        return new ResponseEntity<>(clientService.getUserByCustomParams(), HttpStatus.OK);
    }

    //PUT
//    public ResponseEntity<Object> updateClientInfo(){
//        return null;
//    }

    //Patch
    /*@PatchMapping(path = "/{id}/surveyInfo", consumes = "application/json-patch+json")
    public ResponseEntity<Object> updateClientInfo(@Valid @PathVariable Long id, @RequestBody JsonPatch patch){
        return new ResponseEntity<>(clientService.updateClientSurveyInfo(id,patch), HttpStatus.OK);
    }*/

    public ResponseEntity<Object> updateClientLoginInfo(){
        return null;
    }

}
