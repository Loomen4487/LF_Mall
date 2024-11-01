package com.example.finalProject.dto;

import com.example.finalProject.entity.OrderedEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
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
    private String order_number;
    private boolean isDelivery;
    private String reciever;
    public OrderedDTO(int idx, int product_idx, Date regDate, int count, String address, String detailAddress, String phone, String login_id, boolean isReview, String order_number,boolean isDelivery,String reciever) {
        this.idx = idx;
        this.product_idx = product_idx;
        this.regDate = regDate;
        this.count = count;
        this.address = address;
        this.detailAddress = detailAddress;
        this.phone = phone;
        this.login_id = login_id;
        this.isReview = isReview;
        this.order_number = order_number;
        this.isDelivery = isDelivery;
        this.reciever = reciever;
    }

    private ProductDTO product;
    public OrderedEntity toEntity(){
        return new OrderedEntity(idx,product_idx,regDate,count, address, detailAddress, phone,login_id,isReview,order_number,isDelivery,reciever);
    }


}
