package com.example.finalProject.service;

import com.example.finalProject.dto.MajorDTO;
import com.example.finalProject.dto.MiddleDTO;
import com.example.finalProject.dto.ProductDTO;
import com.example.finalProject.dto.SubDTO;
import com.example.finalProject.entity.MajorEntity;
import com.example.finalProject.entity.MiddleEntity;
import com.example.finalProject.entity.ProductEntity;
import com.example.finalProject.entity.SubEntity;
import com.example.finalProject.repository.MajorRepository;
import com.example.finalProject.repository.MiddleRepository;
import com.example.finalProject.repository.ProductRepository;
import com.example.finalProject.repository.SubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    private final MajorRepository majorRepository;
    private final MiddleRepository middleRepository;
    private final SubRepository subRepository;
    // Integer 타입으로 변경
    public List<ProductDTO> selectIdx(int idx) {
        // List<Integer>로 수정
        List<ProductEntity> li = productRepository.selectIdx(idx);
        List<ProductDTO> dto = new ArrayList<>();
        li.forEach(it->dto.add(it.toDTO()));
        return dto;
    }

    public List<ProductDTO> findByRef(int ref){
        List<ProductEntity> pe = null;
        int major=ref%100,middle=ref%1000;
        if(ref>1000){
            System.out.println("sub");
            pe = productRepository.findByRef(ref);
        }else if(ref>100){
            System.out.println("middle");
            pe = productRepository.findByMiddle_idx(middle);
        }else{
            System.out.println("major");
            pe = productRepository.findByMajor_idx(major);
        }
        List<ProductDTO> dto = new ArrayList<>();
        pe.forEach(item->dto.add(item.toDTO()));
        return dto;
    }

    public List<MajorDTO> findMajor(){
        List<MajorEntity> me = majorRepository.findAll();
        List<MajorDTO> dto = new ArrayList<>();
        me.forEach(item->dto.add(item.toDTO()));
        return dto;
    }
    public List<MiddleDTO> findMiddle(int ref){
        int idx=ref;
        if(idx>1000)idx=ref/1000;
        else if(idx>100)idx=ref/100;
        List<MiddleEntity> me = middleRepository.findByRef(idx);
        List<MiddleDTO> dto = new ArrayList<>();
        me.forEach(item->dto.add(item.toDTO()));
        return dto;
    }

    public List<SubDTO> findSub(int ref){
        List<SubEntity> se = subRepository.findByRef(ref%1000/100);
        List<SubDTO> dto = new ArrayList<>();
        se.forEach(item->dto.add(item.toDTO()));
        return dto;
    }


    // 메인 전부 가져오기
    public List<ProductDTO> findAll(){
        List<ProductEntity> pe = productRepository.findAll();
        List<ProductDTO> dto = new ArrayList<>();
        pe.forEach(item->dto.add(item.toDTO()));
        return dto;
    }

    public List<ProductDTO> findbag(int ref){
        List<ProductEntity> pebag = productRepository.findBybag(ref);
        List<ProductDTO> dto = new ArrayList<>();
        pebag.forEach(item->dto.add(item.toDTO()));
        return dto;
    }
}