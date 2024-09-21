package com.toGames.b2bStrength.dtos.trainings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewTrainingDTO {
    @Value("0")
    private Long id;

    private String name;

    private String description;

    private String difficulty;

    private String[] categories;

    private String videoUrl;

    private String imageUrl;

    private int estTimePerRep;

    private int estCaloriesPerRep;

}
