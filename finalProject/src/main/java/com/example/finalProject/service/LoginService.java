package com.example.finalProject.service;

import com.example.finalProject.dto.LoginDTO;
import com.example.finalProject.entity.LoginEntity;
import com.example.finalProject.repository.LoginRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
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

    // 사용자 아이디로 로그인 정보 조회
    public LoginEntity findById(String username) {
        return loginRepository.findById(username);
    }

    public void save(LoginEntity loginEntity) {
        loginRepository.save(loginEntity);
    }

}
