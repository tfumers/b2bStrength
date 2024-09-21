package com.toGames.b2bStrength.services.users;

import com.toGames.b2bStrength.dtos.users.LoginInfoInDTO;

import java.util.Optional;


public interface UserService {

    Optional<String> updateUserLoginInfo(LoginInfoInDTO loginInfoInDTO);

}
