package com.example.finalProject.entity;

import com.example.finalProject.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;
    private String name;
    private int price;
    private int size;
    private int rate;
    private String image;
    @ManyToOne
    @JoinColumn(name = "category_idx")
    private CategroyEntity category;

    public ProductDTO toDTO(){
        return new ProductDTO(idx,name,price,size,rate,image,category.toDTO());
    }
}
