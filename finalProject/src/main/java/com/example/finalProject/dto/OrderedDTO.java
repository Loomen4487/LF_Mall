package com.example.finalProject.dto;

import com.example.finalProject.entity.OrderedEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderedDTO {
    private int idx;
    private int product_idx;
    private Date regDate;
    private int count;
    private String address;
    private String detailAddress;
    private String phone;
    private String login_id;
    private boolean isReview;

    public OrderedEntity toEntity(){
        return new OrderedEntity(idx,product_idx,regDate,count, address, detailAddress, phone,login_id,isReview);
    }


}
