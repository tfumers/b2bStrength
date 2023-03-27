package com.toGames.b2bStrength.services.clients;

import com.toGames.b2bStrength.dtos.clients.ClientInfoDTO;
import com.toGames.b2bStrength.dtos.clients.RegisterClientDTO;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    Optional<ClientInfoDTO> registerNewUser(RegisterClientDTO registerClientDTO);

    Optional<ClientInfoDTO> currentUserInfo();

    List<ClientInfoDTO> getUserByCustomParams();

    String deleteCurrentUser();
}
