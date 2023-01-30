package com.toGames.b2bStrength.models.routines;

import com.toGames.b2bStrength.models.clients.ClientStatus;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @OneToMany(mappedBy="routine", fetch= FetchType.EAGER)
    private Set<TrainerClientRelation> trainerClientRelations;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id")
    private RoutineStatus status;

    @OneToMany(mappedBy = "routine", fetch = FetchType.EAGER)
    private Set<Daily> dailyActivities;

    private long numOfDays;

    private LocalDate startDate;

    private LocalDate endDate;

    public Routine() {
    }

    public Routine(long statusId, long numOfDays, LocalDate startDate, LocalDate endDate) {
        this.numOfDays = numOfDays;
        this.startDate = startDate;
        this.endDate = endDate;
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
