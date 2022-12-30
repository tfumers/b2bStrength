package com.toGames.b2bStrength.models.routines;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private long statusId;

    private long numOfDays;

    private LocalDate startDate;

    private LocalDate endDate;

    public Routine() {
    }

    public Routine(long statusId, long numOfDays, LocalDate startDate, LocalDate endDate) {
        this.statusId = statusId;
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

    public long getStatusId() {
        return statusId;
    }

    public void setStatusId(long statusId) {
        this.statusId = statusId;
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
