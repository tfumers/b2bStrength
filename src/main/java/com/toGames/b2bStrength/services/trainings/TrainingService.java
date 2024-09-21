package com.toGames.b2bStrength.services.trainings;

import com.github.fge.jsonpatch.JsonPatch;
import com.toGames.b2bStrength.dtos.trainings.*;
import com.toGames.b2bStrength.dtos.utils.TrainingSearchParamsDTO;

import java.util.List;
import java.util.Optional;

public interface TrainingService {

    List<DetailedTrainingOutDTO> getTrainingsByParams(TrainingSearchParamsDTO paramsDTO);
    Optional<DetailedTrainingOutDTO> getTrainingById(Long id);

    List<DetailedTrainingOutDTO> findByNameContainsOrderById(String name);

    List<DetailedTrainingOutDTO> getTrainingsByCategory(String category);

    Optional<DetailedTrainingCategoryDTO> createNewCategory(NewCategoryDTO newCategoryDTO);

    Optional<DetailedTrainingDifficultyDTO> createNewDifficulty(NewDifficultyDTO newDifficultyDTO);

    Optional<DetailedTrainingOutDTO> createNewTraining(NewTrainingDTO newTrainingDTO);

    Optional<DetailedTrainingOutDTO> updateTraining(JsonPatch newTrainingPatch, Long id);

    String deleteTrainingById(Long id);

    String deleteCategoryById(Long id);

    String deleteDifficultyById(Long id);

    List<DetailedTrainingOutDTO> getTrainingsById(TrainingsInDTO trainingIds);
}
