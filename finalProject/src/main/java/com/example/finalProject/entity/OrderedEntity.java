package com.example.finalProject.entity;

import com.example.finalProject.dto.OrderedDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "ordered")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    private int product_idx;
    @CreationTimestamp
    private Date regDate;
    private int count;
    private String address;
    private String detailAddress;
    private String phone;
    private String login_id;
    private boolean isReview;
    private String order_number;
    private boolean isDelivery;
    private String reciever;

    @Builder
    public OrderedEntity(int idx, int product_idx, int count, String address, String detailAddress, String phone, String login_id, boolean isReview, String order_number,String reciever) {
        this.idx = idx;
        this.product_idx = product_idx;
        this.regDate = new Date();
        this.count = count;
        this.address = address;
        this.detailAddress = detailAddress;
        this.phone = phone;
        this.login_id = login_id;
        this.isReview=false;
        this.order_number = order_number;
        this.isDelivery=false;
        this.reciever = reciever;

    }

    public OrderedDTO toDTO(){
        return new OrderedDTO(idx,product_idx,regDate,count ,address,detailAddress,phone,login_id,isReview,order_number,isDelivery,reciever);
    }
}
