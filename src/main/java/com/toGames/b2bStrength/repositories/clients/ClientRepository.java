package com.toGames.b2bStrength.repositories.clients;

import com.toGames.b2bStrength.models.clients.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByLoginInfoEmail(String Email);
}
