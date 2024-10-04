package com.example.finalProject.repository;

import com.example.finalProject.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewEntity,Integer> {
    @Query(value = "select * from review where product_idx=?1",nativeQuery = true)
    List<ReviewEntity> findByProduct_idx(int idx);
}
