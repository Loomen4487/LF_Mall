package com.example.finalProject.repository;

import com.example.finalProject.entity.DeliveryInfoEntity;
import com.example.finalProject.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DeliveryInfoRepository extends JpaRepository<DeliveryInfoEntity, Integer> {
    List<DeliveryInfoEntity> findByLogin_idx(int loginIdx);

    @Query(value = "select * from deliveryinfo where delivery_idx=?1", nativeQuery = true)
    DeliveryInfoEntity findByDelivery_idx(int idx);

    // 로그인된 사용자 (user)의 모든 배송지 정보 삭제
    @Modifying
    @Transactional
    void deleteByLogin(LoginEntity login);
}
