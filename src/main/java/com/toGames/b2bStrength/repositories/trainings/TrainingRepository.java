package com.toGames.b2bStrength.repositories.trainings;

import com.toGames.b2bStrength.models.trainings.Training;
import com.toGames.b2bStrength.models.trainings.TrainingCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Set;

@RepositoryRestResource
public interface TrainingRepository extends JpaRepository<Training, Long> {
    List<Training> findByNameContainsOrderById(String name);
    List<Training> findByNameContainsAndDescriptionContainsOrderById(String name, String description);

    List<Training> findByNameContainsAndDescriptionContainsAndTrainingCategoryRelationsCategoryIdEqualsOrderById(String name, String description, Long catId);

    List<Training> findByNameContainsAndDescriptionContainsAndDifficultyIdEqualsOrderById(String name, String description, Long difId);

    List<Training> findByNameContainsAndDescriptionContainsAndTrainingCategoryRelationsCategoryIdEqualsAndDifficultyIdEqualsOrderById(String name, String description, Long catId, Long difId);
}
