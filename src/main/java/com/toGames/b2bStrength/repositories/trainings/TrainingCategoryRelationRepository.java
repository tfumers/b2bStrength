package com.toGames.b2bStrength.repositories.trainings;

import com.toGames.b2bStrength.models.trainings.TrainingCategoryRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TrainingCategoryRelationRepository extends JpaRepository<TrainingCategoryRelation, Long> {
}
