package com.toGames.b2bStrength.services.trainers;

import com.toGames.b2bStrength.dtos.clients.AvatarInDto;
import com.toGames.b2bStrength.dtos.routines.RoutineExtendedInfoOutDTO;
import com.toGames.b2bStrength.dtos.routines.NewRoutineInDTO;
import com.toGames.b2bStrength.dtos.routines.TrainerClientRelationOutDTO;
import com.toGames.b2bStrength.dtos.trainers.TrainerBasicInfoOutDTO;
import com.toGames.b2bStrength.models.trainers.Trainer;

import java.util.Optional;
import java.util.Set;

public interface CurrentTrainerService {

    public Set<TrainerClientRelationOutDTO> getTrainerClientRelationsByStatus(long status_id);

    public Optional<RoutineExtendedInfoOutDTO> newRoutine(NewRoutineInDTO routineIn);

    public Object updateTrainerAvatar(AvatarInDto avatarInDto);

    public Optional<TrainerBasicInfoOutDTO> getCurrentTrainer();

    public Trainer getTrainerInSession();
}
