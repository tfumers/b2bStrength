package com.toGames.b2bStrength.models.clients;

import com.toGames.b2bStrength.models.routines.TrainerClientRelation;
import com.toGames.b2bStrength.models.users.GenericUser;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
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

    private long level = 1;

    private long experience = 0;

    private String avatar = "";

    //Refactorizar para crear un inicializador por defecto
    public Client(String username, String firstname, String lastname, char sex, String icon, int dni, int phone, String avatar) {
        super(username, firstname, lastname, phone, sex, icon);
        this.dni = dni;
        this.avatar = avatar;
    }

    //Relaciones del JPA

}
