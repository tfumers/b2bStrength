package com.toGames.b2bStrength.dtos.routines;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewRoutineInDTO {
    private long trainerClientRelationId;

    private long clientId;

    private NewDailyInDTO[] dailyActivities;

    private long numOfDays;

    private String startDate;


}
