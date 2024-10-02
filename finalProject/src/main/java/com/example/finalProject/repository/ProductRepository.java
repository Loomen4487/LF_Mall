package com.example.finalProject.repository;

import com.example.finalProject.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
    @Query(value = "select * from product where category_idx = ?1",nativeQuery = true)
    List<ProductEntity> selectIdx(int idx);

    List<ProductEntity> findByRef(int ref);
    @Query(value = "select * from product where middle_idx=?1",nativeQuery = true)
    List<ProductEntity> findByMiddle_idx(int idx);
    @Query(value = "select * from product where major_idx=?1",nativeQuery = true)
    List<ProductEntity> findByMajor_idx(int idx);

    @Query(value = "select * from product where ref = ?1 order by rand() limit 3", nativeQuery = true)
    List<ProductEntity> findBybag(int ref);

}
