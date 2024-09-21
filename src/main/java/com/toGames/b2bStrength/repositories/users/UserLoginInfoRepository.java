package com.toGames.b2bStrength.repositories.users;

import com.toGames.b2bStrength.models.clients.Client;
import com.toGames.b2bStrength.models.users.GenericUser;
import com.toGames.b2bStrength.models.users.UserLoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface UserLoginInfoRepository extends JpaRepository<UserLoginInfo, Long> {

    Optional<UserLoginInfo> findByEmail(String email);
}
