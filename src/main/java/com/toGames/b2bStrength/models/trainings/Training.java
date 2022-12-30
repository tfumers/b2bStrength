package com.toGames.b2bStrength.models.trainings;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String name;

    private String description;

    private String videoUrl;

    private String imageUrl;

    private long difficultyId;

    private int estTimePerRep;

    private int estCaloriesPerRep;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Training() {
    }

    public Training(String name, String description, String videoUrl, String imageUrl, long difficultyId, int estTimePerRep, int estCaloriesPerRep, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.name = name;
        this.description = description;
        this.videoUrl = videoUrl;
        this.imageUrl = imageUrl;
        this.difficultyId = difficultyId;
        this.estTimePerRep = estTimePerRep;
        this.estCaloriesPerRep = estCaloriesPerRep;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getDifficultyId() {
        return difficultyId;
    }

    public void setDifficultyId(long difficultyId) {
        this.difficultyId = difficultyId;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
