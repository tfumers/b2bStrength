package com.toGames.b2bStrength.dtos.trainings;

import com.toGames.b2bStrength.models.trainings.Training;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DetailedTrainingDTO {

    private Long id;

    private String name;

    private String description;

    private String videoUrl;

    private String imageUrl;

    private int estTimePerRep;

    private int estCaloriesPerRep;

    private Boolean isEnabled;

    private Set<TrainingCategoryRelationDTO> categories = new HashSet<>();

    private TrainingDifficultyDTO difficulty;

    public DetailedTrainingDTO(Training training) {
        this.id = training.getId();
        this.categories = training.getTrainingCategoryRelations().stream().map(TrainingCategoryRelationDTO::new).collect(Collectors.toSet());
        this.difficulty = new TrainingDifficultyDTO(training.getDifficulty());
        this.name = training.getName();
        this.description = training.getDescription();
        this.videoUrl = training.getVideoUrl();
        this.imageUrl = training.getImageUrl();
        this.estTimePerRep = training.getEstTimePerRep();
        this.estCaloriesPerRep = training.getEstCaloriesPerRep();
        this.isEnabled = training.getEnabled();
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

    public String getVideoUrl() {
        return videoUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getEstTimePerRep() {
        return estTimePerRep;
    }

    public int getEstCaloriesPerRep() {
        return estCaloriesPerRep;
    }

    public Set<TrainingCategoryRelationDTO> getCategories() {
        return categories;
    }

    public TrainingDifficultyDTO getDifficulty() {
        return difficulty;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }
}
