package com.example.finalProject.service;

import com.example.finalProject.dto.ProductDTO;
import com.example.finalProject.entity.ProductEntity;
import com.example.finalProject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    // Integer 타입으로 변경
    public List<ProductDTO> selectIdx(int idx) {
        // List<Integer>로 수정
        List<ProductEntity> li = productRepository.selectIdx(idx);
        List<ProductDTO> dto = new ArrayList<>();
        li.forEach(it->dto.add(it.toDTO()));
        return dto;
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> recommandProduct(){
        List<ProductEntity> pe = productRepository.recommandProduct();
        List<ProductDTO> dto = new ArrayList<>();
        pe.forEach(item->dto.add(item.toDTO()));
        return dto;
    }

    public ProductDTO findByIdx(int idx){
        ProductEntity pe = productRepository.findByIdxAndCategory_idx(idx,1);
        if(Objects.isNull(pe))throw new IllegalArgumentException("해당 상품이 없습니다.");
        return pe.toDTO();
    }

}