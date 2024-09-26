package com.example.finalProject.security;

import com.example.finalProject.dto.LoginDTO;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Getter
public class PrincipalDetails implements UserDetails, OAuth2User {
    private LoginDTO dto;
    private Map<String,Object> map;

    public PrincipalDetails(LoginDTO dto, Map<String, Object> map) {
        this.dto = dto;
        this.map = map;
    }

    public PrincipalDetails(LoginDTO dto) {
        this.dto = dto;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return map;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> ga = new ArrayList<>();
        ga.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ROLE_"+dto.getRole();
            }
        });
        return ga;
    }

    @Override
    public String getPassword() {
        return dto.getPassword();
    }

    @Override
    public String getUsername() {
        return dto.getId();
    }

    @Override
    public String getName() {
        return "";
    }
}
