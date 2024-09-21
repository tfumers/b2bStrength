package com.toGames.b2bStrength.configurations;

import com.toGames.b2bStrength.models.clients.Client;
import com.toGames.b2bStrength.models.trainers.Trainer;
import com.toGames.b2bStrength.models.users.UserLoginInfo;
import com.toGames.b2bStrength.repositories.clients.ClientRepository;
import com.toGames.b2bStrength.repositories.trainers.TrainerRepository;
import com.toGames.b2bStrength.repositories.users.UserLoginInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpSession;

import static com.toGames.b2bStrength.utils.Constant.*;

@Configuration
public class WebAuthentication extends GlobalAuthenticationConfigurerAdapter {
    @Autowired
    UserLoginInfoRepository userLoginInfoRepository;

    @Autowired
    TrainerRepository trainerRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    HttpSession session;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(emailInput -> {
            emailInput = emailInput;
            UserLoginInfo userLoginInfo = userLoginInfoRepository.findByEmail(emailInput).orElse(null);

            if (userLoginInfo != null)
            {
                Trainer trainer = trainerRepository.findById(userLoginInfo.getId()).orElse(null);
                Client client = clientRepository.findById(userLoginInfo.getId()).orElse(null);


                session.setAttribute(SESSION_ATTR_USER_ID, userLoginInfo.getId());
                if (trainer!=null){
                    return new User(userLoginInfo.getEmail(), userLoginInfo.getPassTest(), AuthorityUtils.createAuthorityList(USER_ROLE_TRAINER));
                }
                else if(client!=null){
                    return  new User(userLoginInfo.getEmail(), userLoginInfo.getPassTest(), AuthorityUtils.createAuthorityList(USER_ROLE_CLIENT));
                }
                else{
                    return new User(userLoginInfo.getEmail(), userLoginInfo.getPassTest(), AuthorityUtils.createAuthorityList(USER_ROLE_ADMIN));
                }
            } else {
                throw new UsernameNotFoundException("Unknown email: " + emailInput);
            }
        });
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


}


