package com.example.finalProject.dto;

import com.example.finalProject.entity.ReviewEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
    private int idx;
    private ProductDTO product;
    private Date regDate;
    private String image;
    private String login_id;

    public ReviewEntity toEntity(){
        return new ReviewEntity(idx,product.toEntity(),regDate,image,login_id);
    }
}
