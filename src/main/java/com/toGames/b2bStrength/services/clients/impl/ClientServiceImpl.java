package com.toGames.b2bStrength.services.clients.impl;

import com.toGames.b2bStrength.dtos.clients.ClientInfoDTO;
import com.toGames.b2bStrength.dtos.clients.RegisterClientDTO;
import com.toGames.b2bStrength.models.clients.Client;
import com.toGames.b2bStrength.repositories.clients.ClientRepository;
import com.toGames.b2bStrength.services.clients.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;



    @Override
    public Optional<ClientInfoDTO> registerNewUser(RegisterClientDTO registerClientDTO) {
        Client newClient = new Client(
                registerClientDTO.getUsername(), registerClientDTO.getFirstname(),
                registerClientDTO.getLastname(), registerClientDTO.getSex(), registerClientDTO.getIcon(),
                registerClientDTO.getDni(), registerClientDTO.getPhone(), registerClientDTO.getAvatar());



        //Metodos de validación(estos métodos van en la clase register dto
        //password valida
        //correo que no exista



        return Optional.empty();
    }


    @Override
    public Optional<ClientInfoDTO> currentUserInfo() {
        return Optional.empty();
    }

    //Get users by params
    @Override
    public List<ClientInfoDTO> getUserByCustomParams() {
        return null;
    }

    @Override
    public String deleteCurrentUser() {
        return null;
    }
}
