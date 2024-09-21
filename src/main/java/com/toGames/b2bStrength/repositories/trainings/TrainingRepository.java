package com.toGames.b2bStrength.repositories.trainings;

import com.toGames.b2bStrength.models.trainings.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface TrainingRepository extends JpaRepository<Training, Long> {
    List<Training> findByNameContainsIgnoreCaseOrderById(String name);

    List<Training> findByDescriptionContainsIgnoreCaseOrderById(String description);
    List<Training> findByTrainingCategoryRelationsCategoryIdEqualsOrderById(Long CatId);

    List<Training> findByDifficultyIdEqualsOrderById(Long difId);
    List<Training> findByNameContainsAndDescriptionContainsOrderById(String name, String description);

    List<Training> findByNameContainsAndDescriptionContainsAndTrainingCategoryRelationsCategoryIdEqualsOrderById(String name, String description, Long catId);

    List<Training> findByNameContainsAndDescriptionContainsAndDifficultyIdEqualsOrderById(String name, String description, Long difId);

    List<Training> findByNameContainsAndDescriptionContainsAndTrainingCategoryRelationsCategoryIdEqualsAndDifficultyIdEqualsOrderById(String name, String description, Long catId, Long difId);
}
