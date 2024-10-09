package com.example.finalProject.dto;

import com.example.finalProject.entity.ReviewEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ReviewDTO {
    private int idx;
    private int product_idx;
    private Date regDate;
    private String image;
    private String login_id;
    private int review_like;
    private String content;

    public ReviewDTO(int idx, int product_idx, Date regDate, String image, String login_id, int review_like, String content) {
        this.idx = idx;
        this.product_idx = product_idx;
        this.regDate = regDate;
        this.image = image;
        this.login_id = login_id;
        this.review_like = review_like;
        this.content = content;
    }

    private ProductDTO product;
    public ReviewEntity toEntity(){
        return new ReviewEntity(idx,product_idx,regDate,image,login_id,review_like,content);
    }
}
