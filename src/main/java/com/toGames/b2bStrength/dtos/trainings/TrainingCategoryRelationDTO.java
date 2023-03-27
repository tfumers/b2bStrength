package com.toGames.b2bStrength.dtos.trainings;

import com.toGames.b2bStrength.models.trainings.TrainingCategoryRelation;

public class TrainingCategoryRelationDTO {

    private Long categoryId;
    private String category;

    private String description;

    public TrainingCategoryRelationDTO() {
    }

    public TrainingCategoryRelationDTO(TrainingCategoryRelation trainingCategoryRelation) {
        this.categoryId = trainingCategoryRelation.getCategory().getId();
        this.category = trainingCategoryRelation.getCategory().getName();
        this.description = trainingCategoryRelation.getCategory().getDescription();
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }
}
