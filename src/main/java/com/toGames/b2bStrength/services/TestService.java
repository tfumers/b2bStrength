package com.toGames.b2bStrength.services;

import com.toGames.b2bStrength.models.clients.Client;
import com.toGames.b2bStrength.models.trainers.Trainer;
import com.toGames.b2bStrength.repositories.clients.ClientRepository;
import com.toGames.b2bStrength.repositories.trainers.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.time.LocalDateTime;

@Service
public class TestService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    TrainerRepository trainerRepository;

    public String createTestClientAndTrainer(){
//        Client testClient = new Client("nashe", "Anashe", "Crank", 'M', 123, "...", LocalDateTime.now(),LocalDateTime.now(), 1, 123,123,1,0,"...",1);
//        Trainer testTrainer = new Trainer("xdd", "Julio", "Rocky", 'M', 123, "...", LocalDateTime.now(), LocalDateTime.now(), 10);
//
//
//        clientRepository.save(testClient);
//        trainerRepository.save(testTrainer);

        return "success";
    }


}
