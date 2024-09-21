package com.toGames.b2bStrength.services.clients.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.toGames.b2bStrength.dtos.clients.ClientBasicInfoOutDTO;
import com.toGames.b2bStrength.dtos.clients.SurveyInfoInDTO;
import com.toGames.b2bStrength.dtos.routines.*;
import com.toGames.b2bStrength.dtos.trainers.TrainerBasicInfoOutDTO;
import com.toGames.b2bStrength.dtos.clients.AvatarInDto;
import com.toGames.b2bStrength.models.clients.Client;
import com.toGames.b2bStrength.models.clients.ClientSurveyInfo;
import com.toGames.b2bStrength.models.routines.Daily;
import com.toGames.b2bStrength.models.routines.Routine;
import com.toGames.b2bStrength.models.routines.TrainerClientRelation;
import com.toGames.b2bStrength.models.routines.TrainerClientRelationStatus;
import com.toGames.b2bStrength.models.trainers.Trainer;
import com.toGames.b2bStrength.repositories.clients.ClientRepository;
import com.toGames.b2bStrength.repositories.clients.ClientSurveyInfoRepository;
import com.toGames.b2bStrength.repositories.routines.DailyRepository;
import com.toGames.b2bStrength.repositories.routines.RoutineRepository;
import com.toGames.b2bStrength.repositories.routines.TrainerClientRelationRepository;
import com.toGames.b2bStrength.repositories.routines.TrainerClientRelationStatusRepository;
import com.toGames.b2bStrength.repositories.trainers.TrainerRepository;
import com.toGames.b2bStrength.services.clients.ClientProgressService;
import com.toGames.b2bStrength.services.clients.ClientService;
import com.toGames.b2bStrength.services.clients.CurrentClientService;
import com.toGames.b2bStrength.utils.Common;
import com.toGames.b2bStrength.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

import static com.toGames.b2bStrength.utils.Constant.*;

@Service
public class CurrentClientServiceImpl implements CurrentClientService {

    ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    HttpSession session;

    @Autowired
    ClientService clientService;

    @Autowired
    ClientProgressService clientProgressService;

    @Autowired
    TrainerRepository trainerRepository;

    @Autowired
    TrainerClientRelationRepository trainerClientRelationRepository;

    @Autowired
    TrainerClientRelationStatusRepository trainerClientRelationStatusRepository;

    @Autowired
    ClientSurveyInfoRepository surveyInfoRepository;

    @Autowired
    RoutineRepository routineRepository;

    @Autowired
    DailyRepository dailyRepository;

    @Override
    public Optional<ClientBasicInfoOutDTO> getCurrentClientInfo() {
        Client currentClient = getClientInSessionAndValidateStatus(CLIENT_STATUS_NOT_REQUIRED);

        ClientBasicInfoOutDTO clientBasicInfoOutDTO = new ClientBasicInfoOutDTO(currentClient);

        return Optional.of(clientBasicInfoOutDTO);
    }

    @Override
    public Optional<ClientBasicInfoOutDTO> updateClientSurveyInfo(JsonPatch patch) {
        //se busca el usuario
        Client currentClient = getClientInSessionAndValidateStatus(CLIENT_STATUS_NO_SURVEY);


        ClientSurveyInfo surveyInfo = surveyInfoRepository.findById(currentClient.getId()).orElse(null);
        ClientSurveyInfo newSurveyInfo;
        try{
            //se lo encuentra, se lo parchea
            newSurveyInfo = applyPatchToClientSurveyInfo(patch, surveyInfo);
        }
        catch (Exception e){
            throw new RuntimeException("No hay valor", e);
        }

        if(newSurveyInfo!=null){
            surveyInfoRepository.save(newSurveyInfo);
            return Optional.of(new ClientBasicInfoOutDTO(currentClient));
        }
        throw new RuntimeException("No hay valor");
    }

    @Override
    public Optional<ClientBasicInfoOutDTO> updateClientSurveyInfo(SurveyInfoInDTO surveyInfoInDTO) {
        //Se validan los datos de ingreso del surveyInfoIn

        //Son validos, se procede a buscar en la bdd los datos existentes
        Client currentClient = getClientInSessionAndValidateStatus(CLIENT_STATUS_NO_SURVEY);

        ClientSurveyInfo currentSurveyInfo = surveyInfoRepository.findById(currentClient.getId()).orElse(null);

        //se procede al reemplazo
        currentSurveyInfo.setWounds(surveyInfoInDTO.getWounds());
        currentSurveyInfo.setHeight(surveyInfoInDTO.getHeight());
        currentSurveyInfo.setStarterWeight(surveyInfoInDTO.getStarterWeight());
        currentSurveyInfo.setPregnancy(surveyInfoInDTO.getPregnancy());
        currentSurveyInfo.setTrainingOrSportsRecord(surveyInfoInDTO.getTrainingOrSportsRecord());
        currentSurveyInfo.setTrainingObjectives(surveyInfoInDTO.getTrainingObjectives());
        currentSurveyInfo.setIllnesses(surveyInfoInDTO.getIllnesses());
        currentSurveyInfo.setAvailableTrainingItems(surveyInfoInDTO.getAvailableTrainingItems());
        currentSurveyInfo.setAvailableTrainingDays(surveyInfoInDTO.getAvailableTrainingDays());
        currentSurveyInfo.setUpdatedAt(Common.setCurrentTime());
        if(currentSurveyInfo.getCreatedAt()==null){
            currentSurveyInfo.setCreatedAt(currentSurveyInfo.getUpdatedAt());
        }

        if(surveyInfoInDTO.getSex().length()==0){
            throw new RuntimeException("the sex cannot be null");
        }
        currentClient.setSex(surveyInfoInDTO.getSex().charAt(0));

        LocalDate birthDate;
        try{
            birthDate = LocalDate.parse(surveyInfoInDTO.getBirthDate());
            currentClient.setBirthDate(birthDate);
        }
        catch (DateTimeParseException e){

        }

        //se guarda en el repositorio
        surveyInfoRepository.save(currentSurveyInfo);
        //Ocurre un error, se retorna un error

        //Exitoso, se retrona el resultado

        surveyInfoRepository.save(currentSurveyInfo);
        clientService.updateClientStatus(currentClient, CLIENT_STATUS_NO_ROUTINE);
        return Optional.of(new ClientBasicInfoOutDTO(currentClient));
    }

    @Override
    public List<TrainerBasicInfoOutDTO> getTrainersInfo() {
        List<TrainerBasicInfoOutDTO> trainers = trainerRepository.findAll().stream().map(TrainerBasicInfoOutDTO::new).collect(Collectors.toList());

        return trainers;
    }

    @Override
    public Optional<ClientBasicInfoOutDTO> newTrainerClientRelation(TrainerClientRelationInDTO newRelationDTO) {
        Client currentClient = getClientInSessionAndValidateStatus(CLIENT_STATUS_NO_ROUTINE);

        Trainer selectedTrainer = trainerRepository.findById((newRelationDTO.getTrainerId())).orElse(null);
        if(selectedTrainer==null)
        {
            throw new RuntimeException("error: el entrenador elegido no existe");
        }

        TrainerClientRelationStatus tcrStatus = trainerClientRelationStatusRepository.findById(TCR_STATUS_PENDING).orElse(null);

        TrainerClientRelation newTrainerClientRelation = new TrainerClientRelation(selectedTrainer,currentClient,currentClient.getSurveyInfo().getTrainingObjectives(), "Espacio destinado a que el entrenador ingrese lo que intenta hacer con esta rutina", Common.setCurrentTime(), Common.setCurrentTime());

        if(tcrStatus==null){
            throw new RuntimeException("error: el status de la tcr es invalido");
        }

        tcrStatus.addTrainerClientRelation(newTrainerClientRelation);

        selectedTrainer.addTrainerClientRelations(newTrainerClientRelation);
        currentClient.addTrainerClientRelations(newTrainerClientRelation);

        clientService.updateClientStatus(currentClient, CLIENT_STATUS_WAITING);

        trainerClientRelationRepository.save(newTrainerClientRelation);
        return Optional.empty();
    }

    @Override
    public Set<RoutineExtendedInfoOutDTO> getRoutines(Long id) {
        Client clientInSession = getClientInSessionAndValidateStatus(CLIENT_STATUS_HAS_ROUTINE);

        Set<TrainerClientRelation> relations = trainerClientRelationRepository.findByClientId(clientInSession.getId());

        Set<Routine> routines = new HashSet<>();
        for (TrainerClientRelation rel: relations) {
            routines.add(rel.getRoutine());
        }

        if(id!=0){
            routines = routines.stream().filter(r -> r.getId()==id).collect(Collectors.toSet());
        }

        return routines.stream().map(RoutineExtendedInfoOutDTO::new).collect(Collectors.toSet());
    }

    @Override
    public Object updateClientAvatar(AvatarInDto avatarInDto) {
        String avatar = String.valueOf(avatarInDto.getId());
        Client clientInSession = getClientInSessionAndValidateStatus(CLIENT_STATUS_NOT_REQUIRED);

        clientInSession.setAvatar(avatar);
        clientInSession.setIcon(avatar);

        clientRepository.save(clientInSession);

        return Optional.empty();
    }

    @Override
    public Optional<RoutineExtendedInfoOutDTO> updateDailyActivities(DailyCompletedInDTO dailyCompletedInDTO) {
        Client currentClient = getClientInSessionAndValidateStatus(CLIENT_STATUS_HAS_ROUTINE);

        Routine routine = routineRepository.findById(dailyCompletedInDTO.getRoutineId()).orElse(null);

        //se debería comprobar si la rutina no fue completada previamente

        if (routine==null){
            throw new RuntimeException("the routine does not exist");
        }

        Daily currentDaily = dailyRepository.findById(dailyCompletedInDTO.getDailyId()).orElse(null);

        if(currentDaily==null||currentDaily.getRoutine().getId()!= routine.getId()){
            throw new RuntimeException("some dailies does not correspond to the current client");
        }

        LocalDate completionDate = Common.setCurrentTime().toLocalDate();

        try{
            completionDate = LocalDate.parse(dailyCompletedInDTO.getCompletedDate());
        }
        catch (DateTimeParseException e){
            completionDate = Common.setCurrentTime().toLocalDate();
        }

        currentDaily.setCompletionDate(completionDate);

        currentDaily.setElapsedTime(dailyCompletedInDTO.getTime());

        //Acá podría haber un método para actualizar algun valor dentro de la información de progreso del cliente, como sumar los puntos y cosas así
        clientProgressService.saveClientProgressByCompletedDaily(currentClient, currentDaily); //Acá guardamos el progreso por defecto
        //por el momento nos vamos a limitar a guardar los datos

        dailyRepository.save(currentDaily);

        return Optional.empty();
    }

    @Override
    public Optional<TrainerBasicInfoOutDTO> getCurrentSelectedTrainer() {
        Client client = getClientInSessionAndValidateStatus(CLIENT_STATUS_WAITING);

        TrainerClientRelation trainerClientRelation = trainerClientRelationRepository.findByClientId(client.getId()).stream().findFirst().orElse(null);

        if(trainerClientRelation!=null){
            return Optional.of(new TrainerBasicInfoOutDTO(trainerClientRelation.getTrainer()));
        }
        else{
            return Optional.empty();
        }
    }


    private Client getClientInSessionAndValidateStatus(Long requiredStatus){
        Long clientId = 0L;
        try{
             clientId = Long.parseLong(session.getAttribute(SESSION_ATTR_USER_ID).toString());
        }
        catch (Exception e){
            throw new RuntimeException("Error en el parseo, de string a Long " + session.getAttribute(SESSION_ATTR_USER_ID)  );
        }

        Client current = clientRepository.findById(clientId).orElse(null);

        if(current==null){
            throw new RuntimeException("El cliente es nulo");
        }

        if(current.getStatus().getId() < requiredStatus){
            throw new RuntimeException("el usuario no tiene status para esta peticion ");
        }

        return current;
    }


    private ClientSurveyInfo applyPatchToClientSurveyInfo(JsonPatch patch, ClientSurveyInfo targetSurveyInfo) throws JsonPatchException, JsonProcessingException {
        JsonNode patched = patch.apply(objectMapper.convertValue(targetSurveyInfo, JsonNode.class));
        return objectMapper.treeToValue(patched, ClientSurveyInfo.class);
    }
}
