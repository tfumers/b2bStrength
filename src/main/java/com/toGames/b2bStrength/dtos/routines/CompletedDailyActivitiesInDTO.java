package com.toGames.b2bStrength.dtos.routines;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CompletedDailyActivitiesInDTO {
    Long routineId;

    DailyCompletedInDTO[] daily;
}
