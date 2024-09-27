package com.example.finalProject.entity;

import com.example.finalProject.dto.LoginDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "login")
@NoArgsConstructor
@Getter
@Setter
public class LoginEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;
    private String id;
    private String password;
    private String provider;
    private String role;
    private String email;

    @Builder
    public LoginEntity(int idx, String id, String password, String provider, String role, String email) {
        this.idx = idx;
        this.id = id;
        this.password = password;
        this.provider = provider;
        this.role = role;
        this.email = email;
    }

    public LoginDTO toDTO(){
        return new LoginDTO(idx,id,password,provider,role,email);
    }
}
