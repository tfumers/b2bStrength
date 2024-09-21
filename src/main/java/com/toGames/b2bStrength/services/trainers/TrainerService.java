package com.toGames.b2bStrength.services.trainers;

import com.toGames.b2bStrength.dtos.trainers.TrainerBasicInfoOutDTO;
import com.toGames.b2bStrength.dtos.trainers.TrainerInfoInDTO;

import java.util.Optional;

public interface TrainerService {

    public Optional<TrainerBasicInfoOutDTO> registerNewTrainer(TrainerInfoInDTO trainerInfo);
}
