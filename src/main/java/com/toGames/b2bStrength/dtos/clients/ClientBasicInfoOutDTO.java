package com.toGames.b2bStrength.dtos.clients;

import com.toGames.b2bStrength.models.clients.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ClientBasicInfoOutDTO {
    private Long id;

    private Long status;

    private String username;

    private String firstname;

    private String lastname;

    private String nationality;

    private int phone;

    private char sex;

    private String icon;

    private int dni;

    private long level;

    private long experience;

    private String avatar;

    private int height;

    private int starterWeight;

    private Boolean pregnancy;

    private String trainingOrSportsRecord;

    private String wounds;
    private String availableTrainingItems;

    private String trainingObjectives;

    private String illnesses;

    private String availableTrainingDays;

    private String birthDate;

    public ClientBasicInfoOutDTO(Client client) {
        this.id = client.getId();
        this.status = client.getStatus().getId();
        this.username = client.getUsername();
        this.firstname = client.getFirstname();
        this.lastname = client.getLastname();
//        this.nationality = client.getNationality().getNationality(); <-- No tenemos nacionalidad aún
        this.phone = client.getPhone();
        this.sex = client.getSex();
        this.icon = client.getIcon();
        this.dni = client.getDni();
        this.level = client.getProgress().getLevel();
        this.experience = client.getProgress().getExperience();
        this.avatar = client.getAvatar();
        this.height = client.getSurveyInfo().getHeight();
        this.starterWeight = client.getSurveyInfo().getStarterWeight();
        this.pregnancy = client.getSurveyInfo().getPregnancy();
        this.trainingOrSportsRecord = client.getSurveyInfo().getTrainingOrSportsRecord();
        this.wounds = client.getSurveyInfo().getWounds();
        this.availableTrainingItems = client.getSurveyInfo().getAvailableTrainingItems();
        this.trainingObjectives = client.getSurveyInfo().getTrainingObjectives();
        this.illnesses = client.getSurveyInfo().getIllnesses();
        this.availableTrainingDays = client.getSurveyInfo().getAvailableTrainingDays();
        if(client.getBirthDate()!=null){
            this.birthDate = client.getBirthDate().toString();
        }
    }

}
