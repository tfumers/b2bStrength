package com.toGames.b2bStrength.dtos.trainings;

import com.toGames.b2bStrength.models.trainings.TrainingCategory;
import com.toGames.b2bStrength.models.trainings.TrainingDifficulty;

public class DetailedTrainingDifficultyDTO {

    private Long id;
    private String name;

    private String description;

    public DetailedTrainingDifficultyDTO() {
    }

    public DetailedTrainingDifficultyDTO(TrainingDifficulty trainingDifficulty) {
        this.id = trainingDifficulty.getId();
        this.name = trainingDifficulty.getName();
        this.description = trainingDifficulty.getDescription();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
