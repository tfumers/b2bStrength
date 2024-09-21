package com.toGames.b2bStrength.dtos.routines;

import com.toGames.b2bStrength.models.routines.Daily;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class DailyOutDTO {
    private long id;

    private int dayNumber;

    private LocalDate proposedDate;

    private LocalDate completionDate;

    private Set<ActivityOutDTO> activities = new HashSet<>();

    public DailyOutDTO(Daily daily){
        this.id = daily.getId();
        this.dayNumber = daily.getDayNumber();
        this.proposedDate = daily.getProposedDate();
        this.completionDate = daily.getCompletionDate();
        this.activities = daily.getActivities().stream().map(ActivityOutDTO::new).collect(Collectors.toSet());
    }
}
