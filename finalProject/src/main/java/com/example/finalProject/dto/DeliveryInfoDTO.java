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
    private String phone1;        // 전화번호 첫 3자리
    private String phone2;        // 중간 4자리
    private String phone3;        // 마지막 4자리
    private String address;
    private String detailAddress;

    public DeliveryInfoEntity toEntity(LoginEntity loginEntity) {
        return new DeliveryInfoEntity(delivery_idx, loginEntity, receiver, phone, address, detailAddress);
    }

    // 합쳐진 전화번호를 phone1, phone2, phone3로 분리
    public void splitPhone() {
        if (phone != null && phone.length() == 11) {
            this.phone1 = phone.substring(0, 3);
            this.phone2 = phone.substring(3, 7);
            this.phone3 = phone.substring(7, 11);
        }
    }

    // phone1, phone2, phone3를 다시 phone으로 합치기
    public void mergePhone() {
        this.phone = phone1 + phone2 + phone3;
    }

}

