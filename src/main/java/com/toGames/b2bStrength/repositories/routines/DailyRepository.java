package com.toGames.b2bStrength.repositories.routines;

import com.toGames.b2bStrength.models.routines.Daily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DailyRepository extends JpaRepository<Daily, Long> {
}
