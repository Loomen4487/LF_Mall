package com.example.finalProject.service;

import com.example.finalProject.dto.CartDTO;
import com.example.finalProject.dto.ProductDTO;
import com.example.finalProject.entity.CartEntity;
import com.example.finalProject.entity.LoginEntity;
import com.example.finalProject.entity.ProductEntity;
import com.example.finalProject.repository.CartRepository;
import com.example.finalProject.repository.LoginRepository;
import com.example.finalProject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final LoginRepository loginRepository;
    public List<CartDTO> findByLogin_id(String id){
        List<CartEntity> ce = cartRepository.findByLogin_id(id);
        List<CartDTO> dto = new ArrayList<>();
        ce.forEach(item->dto.add(item.toDTO()));
        System.out.println("결과 : "+dto);
        return dto;
    }

    @Transactional
    public void insert(HashMap<String,Object> map){
        int idx = Integer.parseInt(map.get("product").toString());
        ProductEntity pe = productRepository.findByIdx(idx);
        LoginEntity le = loginRepository.findById(map.get("login").toString());
        CartEntity ce = new CartEntity(pe,le);
        cartRepository.save(ce);
    }

    @Transactional
    public void delete(int idx){
        CartEntity ce = cartRepository.findByIdx(idx);
        cartRepository.delete(ce);
    }
}
