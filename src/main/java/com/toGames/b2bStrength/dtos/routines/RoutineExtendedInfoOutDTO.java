package com.toGames.b2bStrength.dtos.routines;


import com.toGames.b2bStrength.dtos.trainings.DetailedTrainingOutDTO;
import com.toGames.b2bStrength.models.routines.Activity;
import com.toGames.b2bStrength.models.routines.Daily;
import com.toGames.b2bStrength.models.routines.Routine;
import com.toGames.b2bStrength.models.trainings.Training;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoutineExtendedInfoOutDTO {
    private Long id;

    private Long days;

    private String description;

    private String objective;

    private Set<DailyOutDTO> dailyActivities = new HashSet<>();

    private Set<DetailedTrainingOutDTO> trainingDTOs = new HashSet<>();

    public RoutineExtendedInfoOutDTO(Routine routine){
        this.id = routine.getId();
        this.days = routine.getNumOfDays();
        this.description = routine.getTrainerClientRelation().getDescription();
        this.objective = routine.getTrainerClientRelation().getObjective();
        this.dailyActivities = routine.getDailyActivities().stream().map(DailyOutDTO::new).collect(Collectors.toSet());
        this.trainingDTOs = routine.getDailyActivities().stream().map(Daily::getActivities)
                .map(activities -> activities.stream().map(Activity::getTraining).collect(Collectors.toSet()))
                .flatMap(trainings -> trainings.stream().map(DetailedTrainingOutDTO::new)).collect(Collectors.toSet());

    }

}
