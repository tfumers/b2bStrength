package com.toGames.b2bStrength.repositories.users;

import com.toGames.b2bStrength.models.users.Nationality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface NationalityRepository extends JpaRepository<Nationality, Long> {
}
