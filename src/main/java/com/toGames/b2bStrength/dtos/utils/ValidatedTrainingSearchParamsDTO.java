package com.toGames.b2bStrength.dtos.utils;

public class ValidatedTrainingSearchParamsDTO {

    Long catId = 0L, difId = 0L;

    String name = "", desc = "";

    public ValidatedTrainingSearchParamsDTO() {
    }

    public ValidatedTrainingSearchParamsDTO(Long catId, Long difId, String name, String desc) {
        this.catId = catId;
        this.difId = difId;
        this.name = name;
        this.desc = desc;
    }

    public Long getCatId() {
        return catId;
    }

    public Long getDifId() {
        return difId;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public void setDifId(Long difId) {
        this.difId = difId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
