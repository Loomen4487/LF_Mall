package com.example.finalProject.repository;

import com.example.finalProject.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewEntity,Integer> {
    @Query(value = "select * from review where product_idx=?1",nativeQuery = true)
    List<ReviewEntity> findByProduct_idx(int idx);

    // 마이페이지 내가 작성한 리뷰
    @Query(value = "select * from review where login_id=?1",nativeQuery = true)
    List<ReviewEntity> selectByReviewLogin_id(String id);

    ReviewEntity findByIdx(int idx);
}
