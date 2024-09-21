package com.toGames.b2bStrength.services.users.impl;

import com.toGames.b2bStrength.dtos.users.LoginInfoInDTO;
import com.toGames.b2bStrength.repositories.users.UserLoginInfoRepository;
import com.toGames.b2bStrength.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserLoginInfoRepository userLoginInfoRepository;

    @Override
    public Optional<String> updateUserLoginInfo(LoginInfoInDTO loginInfoInDTO) {
        //Se valida que sean correctos los datos
        //Se busca los datos del usuario
        //Se actualizan
        //Se retorna el resultado


        return Optional.empty();
    }
}
