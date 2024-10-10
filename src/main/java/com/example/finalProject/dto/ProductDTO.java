package com.example.finalProject.dto;

import com.example.finalProject.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {
    private int idx;
    private String name;
    private int price;
    private int size;
    private int rate;
    private String image;
    private int ref;
    private int middle_idx;
    private int major_idx;

    public ProductDTO(int idx, String name, int price, int size, int rate, String image, int ref, int middle_idx, int major_idx) {
        this.idx = idx;
        this.name = name;
        this.price = price;
        this.size = size;
        this.rate = rate;
        this.image = image;
        this.ref = ref;
        this.middle_idx = middle_idx;
        this.major_idx = major_idx;
    }

    public ProductEntity toEntity(){
        return new ProductEntity(idx,name,price,size,rate,image, ref,middle_idx,major_idx);
    }
}
