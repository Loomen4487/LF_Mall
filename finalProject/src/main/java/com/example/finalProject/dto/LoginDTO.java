package com.example.finalProject.dto;

import com.example.finalProject.entity.LoginEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    private int idx;
    private String id;
    private String password;
    private String provider;
    private String role;
    private String email;
    private String phone;

    public LoginEntity toEntity(){
        return new LoginEntity(idx,id,password,provider,role,email,phone);
    }
}
