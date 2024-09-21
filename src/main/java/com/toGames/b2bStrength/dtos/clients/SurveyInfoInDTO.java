package com.toGames.b2bStrength.dtos.clients;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SurveyInfoInDTO {
    private String sex;
    private int height;
    private int starterWeight;
    private Boolean pregnancy;
    private String trainingOrSportsRecord;
    private String availableTrainingItems;
    private String trainingObjectives;
    private String illnesses;
    private String wounds;
    private String birthDate;
    private String availableTrainingDays;

    //    private LocalDateTime createdAt;

//    private LocalDateTime updatedAt;




}
