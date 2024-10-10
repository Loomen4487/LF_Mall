package com.example.finalProject.security;

import com.example.finalProject.entity.LoginEntity;
import com.example.finalProject.repository.LoginRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService {
    private final LoginRepository loginRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginEntity le = loginRepository.findById(username);
        if(!Objects.isNull(le))return new PrincipalDetails(le.toDTO());
        return null;
    }
}
