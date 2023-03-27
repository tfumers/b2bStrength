package com.toGames.b2bStrength.repositories.trainers;

import com.toGames.b2bStrength.models.trainers.TrainerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TrainerTypeRepository extends JpaRepository<TrainerType, Long> {
}
