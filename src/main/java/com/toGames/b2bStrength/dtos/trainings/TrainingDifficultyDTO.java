package com.toGames.b2bStrength.dtos.trainings;

import com.toGames.b2bStrength.models.trainings.TrainingDifficulty;

public class TrainingDifficultyDTO {

    private Long id;
    private String name;

    private String description;

    public TrainingDifficultyDTO() {
    }

    public TrainingDifficultyDTO(TrainingDifficulty difficulty) {
        this.id = difficulty.getId();
        this.name = difficulty.getName();
        this.description = difficulty.getDescription();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
