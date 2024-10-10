package com.example.finalProject.entity;

import com.example.finalProject.dto.LoginDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "login")
@Getter
@NoArgsConstructor
public class LoginEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;
    private String id;
    private String password;
    private String provider;
    private String role;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "login", cascade = CascadeType.ALL, orphanRemoval = true)  // DeliveryInfoEntity에 설정된 login 필드와 연관
    private List<DeliveryInfoEntity> deliveryInfos;  // 로그인 사용자가 가진 여러 배송 정보

    @Builder
    public LoginEntity(int idx, String id, String password, String provider, String role, String email,String phone) {
        this.idx = idx;
        this.id = id;
        this.password = password;
        this.provider = provider;
        this.role = role;
        this.email = email;
        this.phone = phone;

    }

    public LoginDTO toDTO(){
        return new LoginDTO(idx,id,password,provider,role,email,phone);
    }

}
