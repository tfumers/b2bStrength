package com.toGames.b2bStrength.models.clients;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class ClientProgress {

//  relacionar el client_id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;



    private long caloriesBurned;

    private int daysCompleted;

    private int daysCompletedInRow;

    private int maxDaysInRow;

    private LocalDateTime rowStartDate;

    private LocalDateTime maxDaysInRowStartDate;

    public ClientProgress() {
    }

    public ClientProgress(long caloriesBurned, int daysCompleted, int daysCompletedInRow, int maxDaysInRow, LocalDateTime rowStartDate, LocalDateTime maxDaysInRowStartDate) {
        this.caloriesBurned = caloriesBurned;
        this.daysCompleted = daysCompleted;
        this.daysCompletedInRow = daysCompletedInRow;
        this.maxDaysInRow = maxDaysInRow;
        this.rowStartDate = rowStartDate;
        this.maxDaysInRowStartDate = maxDaysInRowStartDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(long caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public int getDaysCompleted() {
        return daysCompleted;
    }

    public void setDaysCompleted(int daysCompleted) {
        this.daysCompleted = daysCompleted;
    }

    public int getDaysCompletedInRow() {
        return daysCompletedInRow;
    }

    public void setDaysCompletedInRow(int daysCompletedInRow) {
        this.daysCompletedInRow = daysCompletedInRow;
    }

    public int getMaxDaysInRow() {
        return maxDaysInRow;
    }

    public void setMaxDaysInRow(int maxDaysInRow) {
        this.maxDaysInRow = maxDaysInRow;
    }

    public LocalDateTime getRowStartDate() {
        return rowStartDate;
    }

    public void setRowStartDate(LocalDateTime rowStartDate) {
        this.rowStartDate = rowStartDate;
    }

    public LocalDateTime getMaxDaysInRowStartDate() {
        return maxDaysInRowStartDate;
    }

    public void setMaxDaysInRowStartDate(LocalDateTime maxDaysInRowStartDate) {
        this.maxDaysInRowStartDate = maxDaysInRowStartDate;
    }
}
