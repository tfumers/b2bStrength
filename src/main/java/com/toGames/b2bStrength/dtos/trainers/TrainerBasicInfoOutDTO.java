package com.toGames.b2bStrength.dtos.trainers;

import com.toGames.b2bStrength.models.trainers.Trainer;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TrainerBasicInfoOutDTO {

    Long id;
    String firstname;
    String lastname;
    String username;
    String icon;
    String avatar;
    String description;
    String phone;

    public TrainerBasicInfoOutDTO(Trainer trainer) {
        this.id = trainer.getId();
        this.firstname = trainer.getFirstname();
        this.lastname = trainer.getLastname();
        this.username = trainer.getUsername();
        this.icon = trainer.getIcon();
        this.avatar = trainer.getIcon();
        this.description =trainer.getDescription();
        this.phone = Integer.toString(trainer.getPhone());
    }
}
