package com.toGames.b2bStrength.models.trainings;

import com.toGames.b2bStrength.models.commons.DatabaseCommon;
import com.toGames.b2bStrength.models.routines.Activity;
import com.toGames.b2bStrength.utils.Common;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Training extends DatabaseCommon {

    @OneToMany(mappedBy="training", fetch= FetchType.EAGER)
    private Set<Activity> activities;

    @OneToMany(mappedBy="training", fetch= FetchType.EAGER)
    private Set<TrainingCategoryRelation> trainingCategoryRelations;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "difficulty_id")
    private TrainingDifficulty difficulty;

    private String name;

    private String description;

    private String videoUrl;

    private String imageUrl;


    private int estTimePerRep;

    private int estCaloriesPerRep;

    public Training() {
    }

    public Training(LocalDateTime createdAt, LocalDateTime updatedAt, Boolean isEnabled, String name, String description, String videoUrl, String imageUrl, int estTimePerRep, int estCaloriesPerRep) {
        super(createdAt, updatedAt, isEnabled);
        this.name = name;
        this.description = description;
        this.videoUrl = videoUrl;
        this.imageUrl = imageUrl;
        this.estTimePerRep = estTimePerRep;
        this.estCaloriesPerRep = estCaloriesPerRep;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public TrainingDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(TrainingDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public int getEstTimePerRep() {
        return estTimePerRep;
    }

    public void setEstTimePerRep(int estTimePerRep) {
        this.estTimePerRep = estTimePerRep;
    }

    public int getEstCaloriesPerRep() {
        return estCaloriesPerRep;
    }

    public void setEstCaloriesPerRep(int estCaloriesPerRep) {
        this.estCaloriesPerRep = estCaloriesPerRep;
    }

    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

    public Set<TrainingCategoryRelation> getTrainingCategoryRelations() {
        return trainingCategoryRelations;
    }

    public void addCategory(TrainingCategory trainingCategory){
        this.trainingCategoryRelations.add(new TrainingCategoryRelation(this, trainingCategory, Common.setCurrentTime(), Common.setCurrentTime()));
    }

    public void setTrainingCategoryRelations(Set<TrainingCategoryRelation> trainingCategoryRelations) {
        this.trainingCategoryRelations = trainingCategoryRelations;
    }
}
