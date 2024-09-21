package com.toGames.b2bStrength.dtos.routines;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewActivityInDTO {
    private int orderNumber;

    private long actTypeId;

    private int actTypeValue;

    private long trainingId;
}
