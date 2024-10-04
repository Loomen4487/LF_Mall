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
    private int product_idx;
    private Date regDate;
    private String image;
    private String login_id;
    private int review_like;
    private String content;

    public ReviewEntity toEntity(){
        return new ReviewEntity(idx,product_idx,regDate,image,login_id,review_like,content);
    }
}
