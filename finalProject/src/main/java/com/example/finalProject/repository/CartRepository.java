package com.example.finalProject.repository;

import com.example.finalProject.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<CartEntity,Integer> {
    List<CartEntity> findByLogin_id(String id);
    CartEntity findByIdx(int idx);
}
