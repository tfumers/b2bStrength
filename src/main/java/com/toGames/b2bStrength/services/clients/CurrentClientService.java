package com.toGames.b2bStrength.services.clients;

import com.github.fge.jsonpatch.JsonPatch;
import com.toGames.b2bStrength.dtos.clients.ClientBasicInfoOutDTO;
import com.toGames.b2bStrength.dtos.clients.SurveyInfoInDTO;
import com.toGames.b2bStrength.dtos.routines.*;
import com.toGames.b2bStrength.dtos.trainers.TrainerBasicInfoOutDTO;
import com.toGames.b2bStrength.dtos.clients.AvatarInDto;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CurrentClientService {
    Optional<ClientBasicInfoOutDTO> getCurrentClientInfo();

    Optional<ClientBasicInfoOutDTO> updateClientSurveyInfo(JsonPatch patch);

    Optional<ClientBasicInfoOutDTO> updateClientSurveyInfo(SurveyInfoInDTO surveyInfoInDTO);

    List<TrainerBasicInfoOutDTO> getTrainersInfo();

    Optional<ClientBasicInfoOutDTO> newTrainerClientRelation(TrainerClientRelationInDTO newTrainerClientRelationDTO);

    Set<RoutineExtendedInfoOutDTO> getRoutines(Long id);

    Object updateClientAvatar(AvatarInDto avatarInDto);

    Optional<RoutineExtendedInfoOutDTO> updateDailyActivities(DailyCompletedInDTO completedDailyActivitiesInDTO);

    Optional<TrainerBasicInfoOutDTO> getCurrentSelectedTrainer();
}
