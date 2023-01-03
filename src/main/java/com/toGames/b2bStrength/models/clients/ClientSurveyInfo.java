package com.toGames.b2bStrength.models.clients;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ClientSurveyInfo {

//      client_id long [pk, ref:- app.clients.id]//relacion uno a uno
    @Id
    @Column(name = "client_id")
    private long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "client_id")
    private Client client;

    private double height;

    private double starter_weight;

    private String trainingOrSportsRecord;

    private String availableTrainingItems;

    private String trainingObjectives;

    private String illnesses;

    private String availableTrainingDays;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public ClientSurveyInfo() {
    }

    public ClientSurveyInfo(double height, double starter_weight, String trainingOrSportsRecord, String availableTrainingItems, String trainingObjectives, String illnesses, String availableTrainingDays, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.height = height;
        this.starter_weight = starter_weight;
        this.trainingOrSportsRecord = trainingOrSportsRecord;
        this.availableTrainingItems = availableTrainingItems;
        this.trainingObjectives = trainingObjectives;
        this.illnesses = illnesses;
        this.availableTrainingDays = availableTrainingDays;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getStarter_weight() {
        return starter_weight;
    }

    public void setStarter_weight(double starter_weight) {
        this.starter_weight = starter_weight;
    }

    public String getTrainingOrSportsRecord() {
        return trainingOrSportsRecord;
    }

    public void setTrainingOrSportsRecord(String trainingOrSportsRecord) {
        this.trainingOrSportsRecord = trainingOrSportsRecord;
    }

    public String getAvailableTrainingItems() {
        return availableTrainingItems;
    }

    public void setAvailableTrainingItems(String availableTrainingItems) {
        this.availableTrainingItems = availableTrainingItems;
    }

    public String getTrainingObjectives() {
        return trainingObjectives;
    }

    public void setTrainingObjectives(String trainingObjectives) {
        this.trainingObjectives = trainingObjectives;
    }

    public String getIllnesses() {
        return illnesses;
    }

    public void setIllnesses(String illnesses) {
        this.illnesses = illnesses;
    }

    public String getAvailableTrainingDays() {
        return availableTrainingDays;
    }

    public void setAvailableTrainingDays(String availableTrainingDays) {
        this.availableTrainingDays = availableTrainingDays;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
