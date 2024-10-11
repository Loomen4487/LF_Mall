package com.example.finalProject.dto;

import com.example.finalProject.entity.CartEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartDTO {
    private int idx;
    private ProductDTO product;
    private LoginDTO login;
    public CartEntity toEntity(){
        return new CartEntity(idx,product.toEntity(),login.toEntity());
    }

    public CartDTO(int idx, ProductDTO product) {
        this.idx = idx;
        this.product = product;
    }
}
