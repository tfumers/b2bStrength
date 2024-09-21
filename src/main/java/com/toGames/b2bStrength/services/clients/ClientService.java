package com.toGames.b2bStrength.services.clients;

import com.github.fge.jsonpatch.JsonPatch;
import com.toGames.b2bStrength.dtos.clients.ClientBasicInfoOutDTO;
import com.toGames.b2bStrength.dtos.clients.RegisterClientDTO;
import com.toGames.b2bStrength.dtos.clients.SurveyInfoInDTO;
import com.toGames.b2bStrength.dtos.users.LoginInfoInDTO;
import com.toGames.b2bStrength.models.clients.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    Optional<ClientBasicInfoOutDTO> testLoginClient(LoginInfoInDTO loginInfoInDTO);

    Optional<ClientBasicInfoOutDTO> registerNewClient(RegisterClientDTO registerClientDTO);

    List<ClientBasicInfoOutDTO> getUserByCustomParams();

    String deleteCurrentUser();

    Client updateClientStatus(Client current, Long statusId);

    Optional<ClientBasicInfoOutDTO> findClientById(long id);
}
