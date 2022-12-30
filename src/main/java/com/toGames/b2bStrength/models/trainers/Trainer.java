package com.toGames.b2bStrength.models.trainers;

import com.toGames.b2bStrength.models.users.GenericUser;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Trainer extends GenericUser {

    private long typeId;

    public Trainer() {
    }

    public Trainer(String username, String firstname, String lastname, char sex, long nationality_id, String icon, LocalDateTime createdAt, LocalDateTime updatedAt, long typeId) {
        super(username, firstname, lastname, sex, nationality_id, icon, createdAt, updatedAt);
        this.typeId = typeId;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }
}
