package com.toGames.b2bStrength.services.clients;

import com.toGames.b2bStrength.models.clients.Client;
import com.toGames.b2bStrength.models.routines.Daily;

public interface ClientProgressService {

    public boolean saveClientProgressByCompletedDaily(Client client, Daily daily);

}
