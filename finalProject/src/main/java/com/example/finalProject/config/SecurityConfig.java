package com.example.finalProject.config;

import com.example.finalProject.security.LoginFailureHandler;
import com.example.finalProject.security.PrincipalOauthUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {
    private final PrincipalOauthUserService principalOauthUserService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security)throws Exception{
        security.csrf(cs->cs.disable())
                .formLogin(login->login.loginPage("/login").usernameParameter("id").loginProcessingUrl("/loginOk").defaultSuccessUrl("/").failureHandler(new LoginFailureHandler()))
                .authorizeHttpRequests(ah->ah.requestMatchers("/user/**").authenticated()
                        .anyRequest().permitAll());
                //.oauth2Login(oauth->oauth.loginPage("/login").userInfoEndpoint(user->user.userService(principalOauthUserService)));
        return security.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
