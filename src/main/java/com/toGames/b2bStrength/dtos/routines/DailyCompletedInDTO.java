package com.toGames.b2bStrength.dtos.routines;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DailyCompletedInDTO {
    long routineId;

    long dailyId;

    String completedDate;

    long time;
}
