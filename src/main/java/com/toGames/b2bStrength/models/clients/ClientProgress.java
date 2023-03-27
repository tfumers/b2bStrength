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

    private long caloriesBurned;

    private int daysCompleted;

    private int daysCompletedInRow;

    private int maxDaysInRow;

    private LocalDateTime rowStartDate;

    private LocalDateTime maxDaysInRowStartDate;

    public ClientProgress(long caloriesBurned, int daysCompleted, int daysCompletedInRow, int maxDaysInRow, LocalDateTime rowStartDate, LocalDateTime maxDaysInRowStartDate) {
        this.caloriesBurned = caloriesBurned;
        this.daysCompleted = daysCompleted;
        this.daysCompletedInRow = daysCompletedInRow;
        this.maxDaysInRow = maxDaysInRow;
        this.rowStartDate = rowStartDate;
        this.maxDaysInRowStartDate = maxDaysInRowStartDate;
    }
}
