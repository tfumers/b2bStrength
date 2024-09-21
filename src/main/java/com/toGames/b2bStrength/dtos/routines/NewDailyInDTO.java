package com.toGames.b2bStrength.dtos.routines;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewDailyInDTO {
    private int dayNumber;

    private String proposedDate;

    private NewActivityInDTO[] activities;
}
