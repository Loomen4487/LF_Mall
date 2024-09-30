package com.example.finalProject.entity;

import com.example.finalProject.dto.OrderedDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "ordered")
@AllArgsConstructor
@NoArgsConstructor
public class OrderedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    private int product_idx;
    @CreationTimestamp
    private Date regDate;
    private String location;
    private String address;
    private String detailAddress;
    private String phone;

    @Builder
    public OrderedEntity(int idx, int product_idx, String location, String address, String detailAddress, String phone) {
        this.idx = idx;
        this.product_idx = product_idx;
        this.regDate = new Date();
        this.location = location;
        this.address = address;
        this.detailAddress = detailAddress;
        this.phone = phone;

    }

    public OrderedDTO toDTO(){
        return new OrderedDTO(idx,product_idx,regDate,location ,address,detailAddress,phone);
    }
}
