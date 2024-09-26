package com.example.finalProject.repository;

import com.example.finalProject.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
    @Query(value = "select * from product where category_idx = ?1",nativeQuery = true)
    List<ProductEntity> selectIdx(int idx);

    @Query(value = "select * from product where category_idx=1 order by rand() limit 6",nativeQuery = true)
    List<ProductEntity> recommandProduct();

    ProductEntity findByIdxAndCategory_idx(int idx,int category_idx);
}
