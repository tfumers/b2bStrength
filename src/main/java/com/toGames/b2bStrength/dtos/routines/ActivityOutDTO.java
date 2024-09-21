package com.toGames.b2bStrength.dtos.routines;

import com.toGames.b2bStrength.models.routines.Activity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActivityOutDTO {

    private long id;

    private int orderNumber;

    private long actTypeId;

    private int actTypeValue;

    private long trainingId;

    public ActivityOutDTO(Activity activity){
        this.id = activity.getId();
        this.orderNumber = activity.getOrderNumber();
        this.actTypeId = activity.getType().getId();
        this.trainingId = activity.getTraining().getId();
        this.actTypeValue = activity.getTypeValue();
    }
}
