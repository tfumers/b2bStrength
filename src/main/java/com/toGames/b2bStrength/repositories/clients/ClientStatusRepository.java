package com.toGames.b2bStrength.repositories.clients;

import com.toGames.b2bStrength.models.clients.ClientStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientStatusRepository extends JpaRepository<ClientStatus, Long> {
}
