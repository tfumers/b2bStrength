package com.toGames.b2bStrength.repositories.trainings;

import com.toGames.b2bStrength.models.trainings.TrainingCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface TrainingCategoryRepository extends JpaRepository<TrainingCategory, Long> {
    Optional<TrainingCategory> findByNameIgnoreCase(String name);
}
