package com.toGames.b2bStrength.models.trainers;

import com.toGames.b2bStrength.models.routines.TrainerClientRelation;
import com.toGames.b2bStrength.models.users.GenericUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Trainer extends GenericUser {

    @OneToMany(mappedBy="trainer", fetch= FetchType.EAGER)
    private Set<TrainerClientRelation> trainerClientRelations;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private TrainerType type;

    public Trainer(String username, String firstname, String lastname, int phone,char sex, String icon) {
        super(username, firstname, lastname, phone, sex, icon);
    }

}
