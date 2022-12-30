package com.toGames.b2bStrength.models.routines;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private long dailyId;

    public int orderNumber;

    private long trainingId;

    private long typeId;

    private long typeValue;

    public Activity() {
    }

    public Activity(long dailyId, int orderNumber, long trainingId, long typeId, long typeValue) {
        this.dailyId = dailyId;
        this.orderNumber = orderNumber;
        this.trainingId = trainingId;
        this.typeId = typeId;
        this.typeValue = typeValue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDailyId() {
        return dailyId;
    }

    public void setDailyId(long dailyId) {
        this.dailyId = dailyId;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public long getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(long trainingId) {
        this.trainingId = trainingId;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public long getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(long typeValue) {
        this.typeValue = typeValue;
    }
}
