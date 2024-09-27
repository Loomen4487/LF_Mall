package com.example.finalProject.entity;

import com.example.finalProject.dto.OrderedDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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

    public OrderedDTO toDTO(){
        return new OrderedDTO(idx,product_idx,regDate,location);
    }
}
