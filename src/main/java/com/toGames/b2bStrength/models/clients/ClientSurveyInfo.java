package com.toGames.b2bStrength.models.clients;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class ClientSurveyInfo {

//      client_id long [pk, ref:- app.clients.id]//relacion uno a uno
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

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
