package com.toGames.b2bStrength.dtos.utils;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
@NoArgsConstructor
public class TrainingSearchParamsDTO {

    @Value("")
    String category, difficulty, name, desc;

    public TrainingSearchParamsDTO( String name, String desc, String category, String difficulty) {
        this.category = category;
        this.difficulty = difficulty;
        this.name = name;
        this.desc = desc;
    }
}
