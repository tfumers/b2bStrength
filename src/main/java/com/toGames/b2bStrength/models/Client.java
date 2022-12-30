package com.toGames.b2bStrength.models;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Client extends GenericUser{

    private long statusId;

    private int dni;

    private int phone;

    private long level;

    private long experience;

    private String avatar;

    public Client() {
    }

    public Client(String username, String firstname, String lastname, char sex, long nationality_id, String icon, LocalDateTime createdAt, LocalDateTime updatedAt,long statusId, int dni, int phone, long level, long experience, String avatar, long nOfRoutines) {
        super(username, firstname, lastname, sex, nationality_id, icon, createdAt, updatedAt);
        this.statusId = statusId;
        this.dni = dni;
        this.phone = phone;
        this.level = level;
        this.experience = experience;
        this.avatar = avatar;
    }

    public long getStatusId() {
        return statusId;
    }

    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }

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
