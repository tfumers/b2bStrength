package com.toGames.b2bStrength.models.routines;

import com.toGames.b2bStrength.models.trainings.Training;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "daily_id")
    private Daily dailyActivity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "training_id")
    private Training training;

    private int orderNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private ActivityType type;

    private int typeValue;

    private boolean isBonus;

    private boolean completed;

    public Activity(int orderNumber, ActivityType activityType, int typeValue) {
        this.orderNumber = orderNumber;
        this.type = activityType;
        this.typeValue = typeValue;
    }
}
