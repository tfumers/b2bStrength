package com.toGames.b2bStrength.services.clients.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.toGames.b2bStrength.dtos.clients.ClientBasicInfoOutDTO;
import com.toGames.b2bStrength.dtos.clients.RegisterClientDTO;
import com.toGames.b2bStrength.dtos.clients.SurveyInfoInDTO;
import com.toGames.b2bStrength.dtos.users.LoginInfoInDTO;
import com.toGames.b2bStrength.models.clients.Client;
import com.toGames.b2bStrength.models.clients.ClientProgress;
import com.toGames.b2bStrength.models.clients.ClientStatus;
import com.toGames.b2bStrength.models.clients.ClientSurveyInfo;
import com.toGames.b2bStrength.models.users.UserLoginInfo;
import com.toGames.b2bStrength.repositories.clients.ClientProgressRepository;
import com.toGames.b2bStrength.repositories.clients.ClientRepository;
import com.toGames.b2bStrength.repositories.clients.ClientStatusRepository;
import com.toGames.b2bStrength.repositories.clients.ClientSurveyInfoRepository;
import com.toGames.b2bStrength.services.clients.ClientService;
import com.toGames.b2bStrength.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.toGames.b2bStrength.utils.Constant.CLIENT_STATUS_NO_SURVEY;
import static com.toGames.b2bStrength.utils.Constant.USER_TYPE_CLIENT;

@Service
public class ClientServiceImpl implements ClientService {

    ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    HttpSession session;

    @Autowired
    ClientStatusRepository statusRepository;

    @Autowired
    ClientSurveyInfoRepository surveyInfoRepository;

    @Autowired
    ClientProgressRepository clientProgressRepository;

    @Override
    public Optional<ClientBasicInfoOutDTO> testLoginClient(LoginInfoInDTO loginInfoInDTO){
        Client client;
        try{
            client = clientRepository.findByLoginInfoEmail(loginInfoInDTO.getEmail()).orElse(null);
        }
        catch (NullPointerException e){
            return Optional.empty();
        }

        if(client==null){
            return Optional.empty();
        }

        if(!loginInfoInDTO.getPassTest().equals(client.getLoginInfo().getPassTest())){
            return Optional.empty();
        }
        return Optional.of(new ClientBasicInfoOutDTO(client));
    }

    @Override
    public Optional<ClientBasicInfoOutDTO> registerNewClient(RegisterClientDTO registerClientDTO) {
        LocalDateTime localCurrentTime = Common.setCurrentTime();

        char clientSex;

        int clientDni, clientPhone;

        try{
            clientSex = registerClientDTO.getSex().charAt(0);
        }
        catch(IndexOutOfBoundsException e){
            clientSex = 'X';
        }

        try{
            clientDni = Integer.parseInt(registerClientDTO.getDni());
        }
        catch(NumberFormatException e){
            clientDni = 0;
        }

        try{
            clientPhone = Integer.parseInt(registerClientDTO.getPhone());
        }
        catch(NumberFormatException e){
            clientPhone = 0;
        }


        Client newClient = new Client(
                registerClientDTO.getUsername(), registerClientDTO.getFirstname(),
                registerClientDTO.getLastname(), clientSex, registerClientDTO.getIcon(),
                clientDni, clientPhone, registerClientDTO.getAvatar(), null);

        //Metodos de validación y asignación por defecto
        //password valida
        //correo que no exista

        //TypeId (1l) corresponde al tipo de usuario que se tiene, el hash (A) se requiere de algo que lo cree, el salt (B) tambien

        String pass = passwordEncoder.encode(registerClientDTO.getPassTest());

        UserLoginInfo newUserInfo = new UserLoginInfo(USER_TYPE_CLIENT,
                registerClientDTO.getEmail(),"A",
                "B", pass,
                localCurrentTime,localCurrentTime,localCurrentTime);


        ClientSurveyInfo newSurveyInfo = new ClientSurveyInfo();

        ClientStatus clientStatus = statusRepository.findById(CLIENT_STATUS_NO_SURVEY).orElse(null);
        if(clientStatus!=null){
            newClient.setStatus(clientStatus);
            clientStatus.addClient(newClient);
        }

        ClientProgress clientProgress = new ClientProgress();
        clientProgress.setClient(newClient);
        newClient.setProgress(clientProgress);;

        newClient.setSurveyInfo(newSurveyInfo);
        newSurveyInfo.setClient(newClient);

        newClient.setLoginInfo(newUserInfo);
        newUserInfo.setUser(newClient);

        clientRepository.save(newClient);

        Optional<ClientBasicInfoOutDTO> clientInfoOutDTO = Optional.of(new ClientBasicInfoOutDTO(newClient));

        return clientInfoOutDTO;
    }

    //Get users by params
    @Override
    public List<ClientBasicInfoOutDTO> getUserByCustomParams() {
        return null;
    }

    @Override
    public String deleteCurrentUser() {
        return null;
    }

    public Client updateClientStatus(Client current, Long statusId){
        ClientStatus status = statusRepository.findById(statusId).orElse(null);

        if(status!=null)
        {
            current.setStatus(status);
            status.addClient(current);
            clientRepository.save(current);
        }
        return current;
    }

    @Override
    public Optional<ClientBasicInfoOutDTO> findClientById(long id) {
        Client client = clientRepository.findById(id).orElse(null);

        if(client!=null){
            return Optional.of(new ClientBasicInfoOutDTO(client));
        }
        else{
            return Optional.empty();
        }
    }

}
