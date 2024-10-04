package com.example.finalProject.entity;

import com.example.finalProject.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;
    private String name;
    private int price;
    private int size;
    private int rate;
    private String image;
    private int ref;
    private int middle_idx;
    private int major_idx;

    public ProductDTO toDTO(){
        return new ProductDTO(idx,name,price,size,rate,image,ref,middle_idx,major_idx);
    }
}
