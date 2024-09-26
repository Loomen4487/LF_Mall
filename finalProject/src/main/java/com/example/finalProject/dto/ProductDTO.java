package com.example.finalProject.dto;

import com.example.finalProject.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private int idx;
    private String name;
    private int price;
    private int size;
    private int rate;
    private String image;
    private CategroyDTO category;

    public ProductEntity toEntity(){
        return new ProductEntity(idx,name,price,size,rate,image, category.toEntity());
    }


}
