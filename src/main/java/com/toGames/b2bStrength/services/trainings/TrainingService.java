package com.toGames.b2bStrength.services.trainings;

import com.github.fge.jsonpatch.JsonPatch;
import com.toGames.b2bStrength.dtos.trainings.*;
import com.toGames.b2bStrength.dtos.utils.TrainingSearchParamsDTO;

import java.util.List;
import java.util.Optional;

public interface TrainingService {

    List<DetailedTrainingDTO> getTrainingsByParams(TrainingSearchParamsDTO paramsDTO);
    Optional<DetailedTrainingDTO> getTrainingById(Long id);

    List<DetailedTrainingDTO> findByNameContainsOrderById(String name);

    List<DetailedTrainingDTO> getTrainingsByCategory(String category);

    Optional<DetailedTrainingCategoryDTO> createNewCategory(NewCategoryDTO newCategoryDTO);

    Optional<DetailedTrainingDifficultyDTO> createNewDifficulty(NewDifficultyDTO newDifficultyDTO);

    Optional<DetailedTrainingDTO> createNewTraining(NewTrainingDTO newTrainingDTO);

    Optional<DetailedTrainingDTO> updateTraining(JsonPatch newTrainingPatch, Long id);

    String deleteTrainingById(Long id);

    String deleteCategoryById(Long id);

    String deleteDifficultyById(Long id);
}
