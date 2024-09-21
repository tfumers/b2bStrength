package com.toGames.b2bStrength.dtos.routines;

import com.toGames.b2bStrength.dtos.clients.ClientBasicInfoOutDTO;
import com.toGames.b2bStrength.models.routines.TrainerClientRelation;
import com.toGames.b2bStrength.utils.Constant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class TrainerClientRelationOutDTO {

    long id;
    ClientBasicInfoOutDTO clientBasicInfoOutDTO;

    RoutineExtendedInfoOutDTO routineExtendedInfoOutDTO;

    private String objective;

    private String description;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    public TrainerClientRelationOutDTO(TrainerClientRelation trainerClientRelation) {
        this.id = trainerClientRelation.getId();
        this.clientBasicInfoOutDTO = new ClientBasicInfoOutDTO(trainerClientRelation.getClient());
        this.objective = trainerClientRelation.getObjective();
        this.description = trainerClientRelation.getDescription();
        this.createdAt = trainerClientRelation.getCreatedAt().toLocalDate();
        this.updatedAt = trainerClientRelation.getUpdatedAt().toLocalDate();

        if(trainerClientRelation.getStatus().getId() == Constant.TCR_STATUS_ACCEPTED){
            this.routineExtendedInfoOutDTO = new RoutineExtendedInfoOutDTO(trainerClientRelation.getRoutine());
        }
        else{
            this.routineExtendedInfoOutDTO = null;
        }
    }
}
