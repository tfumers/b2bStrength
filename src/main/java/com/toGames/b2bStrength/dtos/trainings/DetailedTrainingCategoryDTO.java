package com.toGames.b2bStrength.dtos.trainings;

import com.toGames.b2bStrength.models.trainings.TrainingCategory;

public class DetailedTrainingCategoryDTO {

    private Long id;
    private String name;

    private String description;

    public DetailedTrainingCategoryDTO() {
    }

    public DetailedTrainingCategoryDTO(TrainingCategory trainingCategory) {
        this.id = trainingCategory.getId();
        this.name = trainingCategory.getName();
        this.description = trainingCategory.getDescription();
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
