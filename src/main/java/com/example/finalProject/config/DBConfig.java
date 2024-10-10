package com.example.finalProject.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import javax.sql.DataSource;

@Configuration
public class DBConfig {

    @Bean
    public DataSource dataSource(){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        //hikariConfig.setJdbcUrl("jdbc:mariadb://localhost:3306/db");
        //hikariConfig.setJdbcUrl("jdbc:oracle:thin:@//localhost:1521/orcl");
        hikariConfig.setJdbcUrl("jdbc:mysql://1.220.247.78:3307/final_2405_team4");
        hikariConfig.setUsername("final_2405_team4_user");
        hikariConfig.setPassword("1234");
        hikariConfig.setPoolName("final_project");
        return new HikariDataSource(hikariConfig);
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity security) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = security.getSharedObject(AuthenticationManagerBuilder.class);
        return authenticationManagerBuilder.build();
    }
}
