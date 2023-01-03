package com.toGames.b2bStrength.models.clients;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ClientProgress {

//  relacionar el client_id
    @Id
    @Column(name = "client_id")
    private long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "client_id")
    private Client client;

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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
