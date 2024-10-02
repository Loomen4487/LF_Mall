package com.example.finalProject.entity;

import com.example.finalProject.dto.DeliveryInfoDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "deliveryInfo")
@NoArgsConstructor
public class DeliveryInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int delivery_idx;

    @ManyToOne  // 다대일 관계 설정 (여러 배송 정보가 하나의 로그인 사용자에 속함)
    @JoinColumn(name = "login_idx", referencedColumnName = "idx")  // 외래 키 설정
    private LoginEntity login;  // LoginEntity와 연관 관계 설정

    private String receiver;
    private String phone;
    private String address;
    private String detailAddress;

    @Builder
    public DeliveryInfoEntity(int delivery_idx, LoginEntity login, String receiver, String phone, String address, String detailAddress) {
        this.delivery_idx = delivery_idx;
        this.login = login;
        this.receiver = receiver;
        this.phone = phone;
        this.address = address;
        this.detailAddress = detailAddress;
    }
    public DeliveryInfoDTO toDTO() {
        return new DeliveryInfoDTO(delivery_idx, login.getIdx(), receiver,phone,address,detailAddress);

    }
}


