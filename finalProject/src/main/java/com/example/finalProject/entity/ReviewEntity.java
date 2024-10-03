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
    @ManyToOne
    @JoinColumn(name = "product_idx")
    private ProductEntity product;
    @CreationTimestamp
    private Date regDate;
    private String image;
    private String login_id;

    public ReviewDTO toDTO(){
        return new ReviewDTO(idx,product.toDTO(),regDate,image,login_id);
    }
}
