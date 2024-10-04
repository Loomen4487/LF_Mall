package com.example.finalProject.entity;

import com.example.finalProject.dto.ReviewDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "review")
@AllArgsConstructor
@NoArgsConstructor
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;
    private int product_idx;
    @CreationTimestamp
    private Date regDate;
    private String image;
    private String login_id;
    private int review_like;
    private String content;

    public ReviewDTO toDTO(){
        return new ReviewDTO(idx,product_idx,regDate,image,login_id,review_like,content);
    }
}
