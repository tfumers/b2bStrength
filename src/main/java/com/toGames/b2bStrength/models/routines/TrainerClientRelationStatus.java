package com.toGames.b2bStrength.models.routines;

import com.toGames.b2bStrength.models.clients.Client;
import com.toGames.b2bStrength.models.trainers.Trainer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainerClientRelationStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String status;

    @OneToMany(mappedBy="status", fetch= FetchType.EAGER)
    private Set<TrainerClientRelation> trainerClientRelations = new HashSet<>();

    public void addTrainerClientRelation(TrainerClientRelation trainerClientRelations) {
        this.trainerClientRelations.add(trainerClientRelations);
        trainerClientRelations.setStatus(this);
    }
}
