package com.toGames.b2bStrength.services.trainers.impl;

import com.toGames.b2bStrength.dtos.clients.ClientBasicInfoOutDTO;
import com.toGames.b2bStrength.dtos.clients.RegisterClientDTO;
import com.toGames.b2bStrength.dtos.trainers.TrainerBasicInfoOutDTO;
import com.toGames.b2bStrength.dtos.trainers.TrainerInfoInDTO;
import com.toGames.b2bStrength.models.clients.Client;
import com.toGames.b2bStrength.models.clients.ClientStatus;
import com.toGames.b2bStrength.models.clients.ClientSurveyInfo;
import com.toGames.b2bStrength.models.trainers.Trainer;
import com.toGames.b2bStrength.models.users.UserLoginInfo;
import com.toGames.b2bStrength.repositories.trainers.TrainerRepository;
import com.toGames.b2bStrength.services.trainers.TrainerService;
import com.toGames.b2bStrength.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

import static com.toGames.b2bStrength.utils.Constant.*;

@Service
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    TrainerRepository trainerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Optional<TrainerBasicInfoOutDTO> registerNewTrainer(@Valid TrainerInfoInDTO trainerInfo) {
        LocalDateTime localCurrentTime = Common.setCurrentTime();
        String message = "";

        LocalDate birthDate = null;
        try
        {
           birthDate =  LocalDate.parse(trainerInfo.getBirthDate(), DateTimeFormatter.ofPattern("dd MM yyyy"));
        }
        catch (DateTimeParseException e)
        {
            message += e.getMessage();
        }
        int phoneNumber = 0;
        try{
            phoneNumber = Integer.parseInt(trainerInfo.getPhone());
        }
        catch (NumberFormatException e){
            message += e.getMessage();
        }

        Trainer newTrainer = new Trainer(
                trainerInfo.getUsername(), trainerInfo.getFirstname(),
                trainerInfo.getLastname(), phoneNumber,
                trainerInfo.getSex(), trainerInfo.getIcon(), trainerInfo.getDescription(), birthDate);

        //Metodos de validación y asignación por defecto
        //password valida
        //correo que no exista

        //TypeId (1l) corresponde al tipo de usuario que se tiene, el hash (A) se requiere de algo que lo cree, el salt (B) tambien

        String pass = passwordEncoder.encode(trainerInfo.getPassTest());

        UserLoginInfo newUserInfo = new UserLoginInfo(USER_TYPE_TRAINER,
                trainerInfo.getEmail(),"A",
                "B", pass,
                localCurrentTime,localCurrentTime,localCurrentTime);

        newTrainer.setLoginInfo(newUserInfo);
        newUserInfo.setUser(newTrainer);

        trainerRepository.save(newTrainer);

        TrainerBasicInfoOutDTO trainerInfoOutDTO = new TrainerBasicInfoOutDTO(newTrainer);

        return Optional.of(trainerInfoOutDTO);
    }
}
