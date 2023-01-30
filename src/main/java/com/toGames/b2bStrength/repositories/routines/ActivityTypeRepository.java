package com.toGames.b2bStrength.repositories.routines;

import com.toGames.b2bStrength.models.routines.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ActivityTypeRepository extends JpaRepository<ActivityType, Long> {
}
