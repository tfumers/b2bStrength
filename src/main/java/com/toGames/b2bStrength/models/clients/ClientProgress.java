package com.toGames.b2bStrength.models.clients;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ClientProgress {

//  relacionar el client_id
    @Id
    @Column(name = "client_id")
    private long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "client_id")
    private Client client;


    private long level = 1;

    private long experience = 0;

    private long totalExperience = 0;
    private long totalCaloriesBurnt;

    private long clientTimeElapsed;

    private long trainingRecommendedTime;

    private int completedDays;

    private int completedOnProposedDays;

    private int proposedBonusActivities;
    private int completedBonusActivities;

    private long caloriesBurntOnBonusActivities;

    public ClientProgress(long totalCaloriesBurnt, long clientTimeElapsed, long trainingRecommendedTime, int completedDays, int completedOnProposedDays, int completedBonusActivities, long caloriesBurntOnBonusActivities) {
        this.totalCaloriesBurnt = totalCaloriesBurnt;
        this.clientTimeElapsed = clientTimeElapsed;
        this.trainingRecommendedTime = trainingRecommendedTime;
        this.completedDays = completedDays;
        this.completedOnProposedDays = completedOnProposedDays;
        this.completedBonusActivities = completedBonusActivities;
        this.caloriesBurntOnBonusActivities = caloriesBurntOnBonusActivities;
    }

    public void setExperience(long experience){
        this.experience += experience;
    }

    public void addTotalExperience(long experience){
        this.totalExperience += experience;
    }

    public void addCaloriesBurnt(long calories){
        this.totalCaloriesBurnt += calories;
    }

    public void addTimeElapsed(long time){
        this.clientTimeElapsed += time;
    }

    public void addEstimatedTrainingTime(long time){
        this.trainingRecommendedTime += time;
    }

    public void addCompletedDay(){
        this.completedDays++;
    }

    public void addCompletedOnProposedDay(){
        this.completedOnProposedDays++;
    }

    public void addBonusActivityCompleted(){
        this.completedBonusActivities++;
    }

    public void addProposedBonusActivity(){
        this.proposedBonusActivities++;
    }

    public void addBurntCaloriesOnBonusActivity(long calories){
        this.caloriesBurntOnBonusActivities += (calories);
    }

    public void addLevels(int levels){
        this.level = this.level + levels;
    }
}
