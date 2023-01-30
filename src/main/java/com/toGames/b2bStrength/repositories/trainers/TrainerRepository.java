package com.toGames.b2bStrength.repositories.trainers;

import com.toGames.b2bStrength.models.trainers.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
