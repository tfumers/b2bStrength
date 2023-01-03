package com.toGames.b2bStrength.models.routines;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Daily {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "routine_id")
    private Routine routine;

    @OneToMany(mappedBy = "dailyActivity", fetch = FetchType.EAGER)
    private Set<Activity> activities;

    private int dayNumber;

    private LocalDate proposedDate;

    private LocalDate completionDate;

    public Daily() {
    }

    public Daily(long routineId, int dayNumber, LocalDate proposedDate, LocalDate completionDate) {
        this.dayNumber = dayNumber;
        this.proposedDate = proposedDate;
        this.completionDate = completionDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public LocalDate getProposedDate() {
        return proposedDate;
    }

    public void setProposedDate(LocalDate proposedDate) {
        this.proposedDate = proposedDate;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }
}
