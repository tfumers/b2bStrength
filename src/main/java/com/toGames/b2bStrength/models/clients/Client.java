package com.toGames.b2bStrength.models.clients;

import com.toGames.b2bStrength.models.routines.TrainerClientRelation;
import com.toGames.b2bStrength.models.users.GenericUser;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Client extends GenericUser {

//        @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private Long id;
//
//    //...
//
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    private Address address;

    //Relaciones del JPA
    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ClientSurveyInfo surveyInfo;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ClientProgress progress;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id")
    private ClientStatus status;

    @OneToMany(mappedBy="trainer", fetch= FetchType.EAGER)
    private Set<TrainerClientRelation> trainerClientRelations;

    private int dni;

    private int phone;

    private long level = 1;

    private long experience = 0;

    private String avatar = "";

    public Client() {
    }




    //Refactorizar para crear un inicializador por defecto
    public Client(String username, String firstname, String lastname, char sex, long nationality_id, String icon, LocalDateTime createdAt, LocalDateTime updatedAt, long statusIddd, int dni, int phone, long level, long experience, String avatar, long nOfRoutines) {
        super(username, firstname, lastname, sex, nationality_id, icon, createdAt, updatedAt);
        this.dni = dni;
        this.phone = phone;
        this.level = level;
        this.experience = experience;
        this.avatar = avatar;
    }

    //Relaciones del JPA

    public ClientSurveyInfo getSurveyInfo() {
        return surveyInfo;
    }

    public void setSurveyInfo(ClientSurveyInfo surveyInfo) {
        this.surveyInfo = surveyInfo;
    }

    public ClientProgress getProgress() {
        return progress;
    }

    public void setProgress(ClientProgress progress) {
        this.progress = progress;
    }

    public ClientStatus getStatus() {
        return status;
    }

    public void setStatus(ClientStatus status) {
        this.status = status;
    }

    //Fin relaciones JPA

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }

    public long getExperience() {
        return experience;
    }

    public void setExperience(long experience) {
        this.experience = experience;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
