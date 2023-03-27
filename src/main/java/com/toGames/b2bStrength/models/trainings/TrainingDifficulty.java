package com.toGames.b2bStrength.models.trainings;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TrainingDifficulty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @OneToMany(mappedBy = "difficulty", fetch = FetchType.EAGER)
    private Set<Training> trainings = new HashSet<>();

    private String name;

    private String description;

    public TrainingDifficulty() {
    }

    public TrainingDifficulty(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Training> getTrainings() {
        return trainings;
    }
}
