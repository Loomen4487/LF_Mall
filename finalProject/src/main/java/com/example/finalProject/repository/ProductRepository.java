package com.example.finalProject.repository;

import com.example.finalProject.dto.ProductDTO;
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

    // 관리자 계정 주문내역 보기
    @Query(value = "select * from product limit ?1,?2",nativeQuery = true)
    List<ProductEntity> selectOrderListAll(int startNo,int pageSize);

    // 관리자 계정 주문내역 전체 개수
    @Query(value = "select count(*) from product",nativeQuery = true)
    int selectCount();
}
