package com.toGames.b2bStrength.models.routines;

import com.toGames.b2bStrength.models.trainings.Training;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
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

    public int orderNumber;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private ActivityType type;

    private long typeValue;

    public Activity() {
    }

    public Activity(long dailyId, int orderNumber, long trainingId, long typeId, long typeValue) {
        this.orderNumber = orderNumber;
        this.typeValue = typeValue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public long getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(long typeValue) {
        this.typeValue = typeValue;
    }
}
