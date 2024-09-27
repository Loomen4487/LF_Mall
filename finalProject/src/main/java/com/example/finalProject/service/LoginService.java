package com.example.finalProject.service;

import com.example.finalProject.dto.LoginDTO;
import com.example.finalProject.entity.LoginEntity;
import com.example.finalProject.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginRepository loginRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public void insert(LoginDTO dto){
        String rawPassword = dto.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        dto.setRole("USER");
        dto.setPassword(encPassword);
        loginRepository.save(dto.toEntity());
    }

    public void updatePassword(String rawPassword,String email) {
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        LoginEntity le = loginRepository.findByEmail(email);
        if(!Objects.isNull(le)){
            LoginDTO d = le.toDTO();
            d.setPassword(encPassword);
            loginRepository.save(d.toEntity());

        }
    }

    public LoginDTO findById(String username) {
        return loginRepository.findById(username).toDTO();
    }

    public void save(LoginDTO loginEntity) {
        loginRepository.save(loginEntity.toEntity());
    }
}
