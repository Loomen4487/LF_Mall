package com.example.finalProject.dto;

import com.example.finalProject.entity.DeliveryInfoEntity;
import com.example.finalProject.entity.LoginEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
        return new LoginEntity(idx,id,password,provider,role,email,phone,deliveryInfos);
    }

    // deliveryInfos 리스트 추가
    private List<DeliveryInfoEntity> deliveryInfos;


}
