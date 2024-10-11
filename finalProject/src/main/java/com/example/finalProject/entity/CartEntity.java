package com.example.finalProject.entity;

import com.example.finalProject.dto.CartDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart")
@AllArgsConstructor
@NoArgsConstructor
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;
    @ManyToOne
    @JoinColumn(name = "product_idx")
    private ProductEntity product;


    @ManyToOne
    @JoinColumn(name = "login_idx")
    private LoginEntity login;

    public CartEntity(ProductEntity product, LoginEntity login) {
        this.product = product;
        this.login = login;
    }
    public CartDTO toDTO(){
        return new CartDTO(idx,product.toDTO());
    }
}
