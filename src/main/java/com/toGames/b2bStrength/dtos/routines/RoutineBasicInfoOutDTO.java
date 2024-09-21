package com.toGames.b2bStrength.dtos.routines;

import com.toGames.b2bStrength.models.routines.Routine;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RoutineBasicInfoOutDTO {
    private Long id;

    private Long days;

    private String description;

    private String objective;

    public RoutineBasicInfoOutDTO(Routine routine) {
        this.id = routine.getId();
        this.days = routine.getNumOfDays();
        this.description = routine.getTrainerClientRelation().getDescription();
        this.objective = routine.getTrainerClientRelation().getObjective();
    }
}
