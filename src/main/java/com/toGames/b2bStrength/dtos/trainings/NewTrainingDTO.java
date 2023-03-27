package com.toGames.b2bStrength.dtos.trainings;

public class NewTrainingDTO {

    private String name;

    private String description;

    private Long[] categoryIds;

    private Long difficultyId;

    private String videoUrl;

    private String imageUrl;

    private int estTimePerRep;

    private int estCaloriesPerRep;

    public NewTrainingDTO() {
    }

    public NewTrainingDTO(String name, String description, Long[] categoryIds, Long difficultyId, String videoUrl, String imageUrl, int estTimePerRep, int estCaloriesPerRep) {
        this.name = name;
        this.description = description;
        this.categoryIds = categoryIds;
        this.difficultyId = difficultyId;
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

    public Long[] getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(Long[] categoryIds) {
        this.categoryIds = categoryIds;
    }

    public Long getDifficultyId() {
        return difficultyId;
    }

    public void setDifficultyId(Long difficultyId) {
        this.difficultyId = difficultyId;
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
}
