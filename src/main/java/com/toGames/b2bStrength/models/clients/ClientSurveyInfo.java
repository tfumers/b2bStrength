package com.toGames.b2bStrength.models.clients;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
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

    private Boolean pregnancy;

    private String trainingOrSportsRecord;

    private String availableTrainingItems;

    private String trainingObjectives;

    private String illnesses;

    private String availableTrainingDays;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public ClientSurveyInfo(double height, double starter_weight, Boolean pregnancy, String trainingOrSportsRecord, String availableTrainingItems, String trainingObjectives, String illnesses, String availableTrainingDays, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.height = height;
        this.starter_weight = starter_weight;
        this.pregnancy = pregnancy;
        this.trainingOrSportsRecord = trainingOrSportsRecord;
        this.availableTrainingItems = availableTrainingItems;
        this.trainingObjectives = trainingObjectives;
        this.illnesses = illnesses;
        this.availableTrainingDays = availableTrainingDays;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
