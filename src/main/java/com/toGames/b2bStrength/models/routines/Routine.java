package com.toGames.b2bStrength.models.routines;

import com.toGames.b2bStrength.models.clients.ClientStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @OneToOne(mappedBy = "routine", fetch = FetchType.EAGER)
    private TrainerClientRelation trainerClientRelation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id")
    private RoutineStatus status;

    @OneToMany(mappedBy = "routine", fetch = FetchType.EAGER)
    private Set<Daily> dailyActivities = new HashSet<>();

    private long numOfDays;

    private LocalDate startDate;

    private LocalDate endDate;

    public Routine(long numOfDays, LocalDate startDate) {
        this.numOfDays = numOfDays;
        this.startDate = startDate;
        this.endDate = startDate.plus(numOfDays, ChronoUnit.DAYS);
    }

    public void addDailyActivities(Daily dailyActivity) {
        this.dailyActivities.add(dailyActivity);
        dailyActivity.setRoutine(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumOfDays() {
        return numOfDays;
    }

    public void setNumOfDays(long numOfDays) {
        this.numOfDays = numOfDays;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
