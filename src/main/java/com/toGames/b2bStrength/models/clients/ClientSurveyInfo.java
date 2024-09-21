package com.toGames.b2bStrength.models.clients;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private int height;

    private int starterWeight;

    private Boolean pregnancy;

    private String trainingOrSportsRecord;

    private String availableTrainingItems;

    private String trainingObjectives;

    private String illnesses;

    private String wounds;
    private String availableTrainingDays;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public ClientSurveyInfo(int height, int starterWeight, Boolean pregnancy, String trainingOrSportsRecord, String availableTrainingItems, String trainingObjectives, String illnesses, String wounds, String availableTrainingDays, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.height = height;
        this.starterWeight = starterWeight;
        this.pregnancy = pregnancy;
        this.trainingOrSportsRecord = trainingOrSportsRecord;
        this.availableTrainingItems = availableTrainingItems;
        this.trainingObjectives = trainingObjectives;
        this.illnesses = illnesses;
        this.wounds = wounds;
        this.availableTrainingDays = availableTrainingDays;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
