package com.toGames.b2bStrength.services.routines;

import com.toGames.b2bStrength.dtos.routines.NewRoutineInDTO;
import com.toGames.b2bStrength.dtos.routines.RoutineExtendedInfoOutDTO;

import java.util.Optional;

public interface RoutineService {

    public Optional<RoutineExtendedInfoOutDTO> getRoutineById(long id);

    public Optional<RoutineExtendedInfoOutDTO> newRoutine(NewRoutineInDTO newRoutineInDTO);
}
