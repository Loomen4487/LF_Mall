package com.example.finalProject.dto;

import com.example.finalProject.entity.DeliveryInfoEntity;
import com.example.finalProject.entity.LoginEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryInfoDTO {
    private int delivery_idx;
    private int login_idx;
    private String receiver;
    private String phone;
    private String address;
    private String detailAddress;

    public DeliveryInfoEntity toEntity(LoginEntity loginEntity) {
        return new DeliveryInfoEntity(delivery_idx, loginEntity, receiver, phone, address, detailAddress);
    }

}

