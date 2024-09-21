package com.toGames.b2bStrength.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.toGames.b2bStrength.utils.Constant.*;

@EnableWebSecurity
@Configuration
public class WebAuthorization extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/api/v1.0/clients","/api/v1.0/login","/api/v1.0/trainers").permitAll()
                .antMatchers("/api/v1.0/clients/current/**").hasAuthority(USER_ROLE_CLIENT)
                .antMatchers(HttpMethod.GET ,"/api/v1.0/trainings/**").hasAnyAuthority(USER_ROLE_CLIENT, USER_ROLE_TRAINER, USER_ROLE_ADMIN)
                .antMatchers("/api/v1.0/logout").hasAnyAuthority(USER_ROLE_CLIENT, USER_ROLE_ADMIN, USER_ROLE_TRAINER)
                .antMatchers("/api/v1.0/clients/**").hasAnyAuthority(USER_ROLE_TRAINER, USER_ROLE_ADMIN)
                .antMatchers("/api/v1.0/clients/**","/api/v1.0/routines/**","/api/v1.0/trainers/**").hasAnyAuthority(USER_ROLE_TRAINER, USER_ROLE_ADMIN)
                .antMatchers("/api/v1.0/trainers/current/**").hasAnyAuthority(USER_ROLE_TRAINER, USER_ROLE_ADMIN)
                .antMatchers(HttpMethod.POST,"/api/v1.0/trainings/**").hasAnyAuthority(USER_ROLE_TRAINER, USER_ROLE_ADMIN);
//                .antMatchers("/web/js/index.js", "/web/index.html", "/web/payments.html",
//                        "/web/css/**", "/web/img/**").permitAll()  // Permito a cualquier usuario ingresar al login.
//                .antMatchers("/rest/**" , "/h2-console").hasAuthority("ADMIN") // rest y console solo para admin
//                .antMatchers(HttpMethod.POST, "/api/clients").permitAll() //permito a todos registrar un nuevo cliente
//                .antMatchers(HttpMethod.POST, "/api/transactions").hasAnyAuthority("CLIENT", "ADMIN") //permito a clientes y admin hacer transacciones
//                .antMatchers(HttpMethod.POST, "/api/loans").hasAnyAuthority("CLIENT", "ADMIN") //permito a clientes y admin hacer transacciones
//                .antMatchers(HttpMethod.POST, "/api/clients/**", "/clients/current/creditCards/**").hasAnyAuthority("CLIENT", "ADMIN") //Los post para tarjetas, etc para clientes y admin
//                .antMatchers(HttpMethod.GET, "/api/clients/current/loans").hasAnyAuthority("CLIENT", "ADMIN") // Cualquier current solo client y admin
//                .antMatchers(HttpMethod.GET, "/api/loans").hasAnyAuthority("CLIENT", "ADMIN") // Cualquier current solo client y admin
//                .antMatchers(HttpMethod.GET, "/api/**/current/**").hasAnyAuthority("CLIENT", "ADMIN") // Cualquier current solo client y admin
//                .antMatchers("/api/**").hasAnyAuthority("ADMIN") // Administrador puede acceder a cualquier get y post de api
//                .antMatchers("/**").hasAnyAuthority("CLIENT", "ADMIN");



        http.formLogin()
                .permitAll()
                .usernameParameter("email")
                .passwordParameter("passTest")
                .loginPage("/api/v1.0/login");


        http.logout().logoutUrl("/api/v1.0/logout");

       /* http.sessionManagement().maximumSessions(1)
                .maxSessionsPreventsLogin(true); // Invalida los logins posteriores.*/

        // turn off checking for CSRF tokens
        http.csrf().disable();

        //disabling frameOptions so h2-console can be accessed
        http.headers().frameOptions().disable();

        // if user is not authenticated, just send an authentication failure response
        http.exceptionHandling().authenticationEntryPoint((req, res, exc) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED));

        // if login is successful, just clear the flags asking for authentication
        http.formLogin().successHandler((req, res, auth) -> clearAuthenticationAttributes(req));

        // if login fails, just send an authentication failure response
        http.formLogin().failureHandler((req, res, exc) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED));

        // if logout is successful, just send a success response
        http.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());
    }

    private void clearAuthenticationAttributes(HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        if (session != null) {

            session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);

        }

    }
}
