package com.toGames.b2bStrength.models.trainers;

import com.toGames.b2bStrength.models.routines.TrainerClientRelation;
import com.toGames.b2bStrength.models.users.GenericUser;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Trainer extends GenericUser {

    @OneToMany(mappedBy="trainer", fetch= FetchType.EAGER)
    private Set<TrainerClientRelation> trainerClientRelations;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private TrainerType type;

    public Trainer() {
    }

    public Trainer(String username, String firstname, String lastname, char sex, long nationality_id, String icon, LocalDateTime createdAt, LocalDateTime updatedAt, long typeId) {
        super(username, firstname, lastname, sex, nationality_id, icon, createdAt, updatedAt);
    }

}
