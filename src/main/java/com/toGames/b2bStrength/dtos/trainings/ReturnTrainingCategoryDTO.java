package com.toGames.b2bStrength.dtos.trainings;

import com.toGames.b2bStrength.models.trainings.TrainingCategory;

public class ReturnTrainingCategoryDTO {

    private String name;

    private String description;

    public ReturnTrainingCategoryDTO() {
    }

    public ReturnTrainingCategoryDTO(TrainingCategory trainingCategory) {
        this.name = trainingCategory.getName();
        this.description = trainingCategory.getDescription();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
