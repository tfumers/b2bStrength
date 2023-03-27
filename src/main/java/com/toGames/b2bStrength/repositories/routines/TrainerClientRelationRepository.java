package com.toGames.b2bStrength.repositories.routines;

import com.toGames.b2bStrength.models.routines.TrainerClientRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TrainerClientRelationRepository extends JpaRepository<TrainerClientRelation, Long> {
}
