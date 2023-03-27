package com.toGames.b2bStrength.dtos.utils;

import org.springframework.web.bind.annotation.RequestParam;

public class TrainingSearchParamsDTO {

    String catId, difId, name, desc;


    public TrainingSearchParamsDTO() {
    }

    public TrainingSearchParamsDTO(String catId, String difId, String name, String desc) {
        this.catId = catId;
        this.difId = difId;
        this.name = name;
        this.desc = desc;
    }

    public String getCatId() {
        return catId;
    }

    public String getDifId() {
        return difId;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
