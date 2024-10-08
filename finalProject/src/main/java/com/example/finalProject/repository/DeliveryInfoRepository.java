package com.example.finalProject.repository;

import com.example.finalProject.entity.DeliveryInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeliveryInfoRepository extends JpaRepository<DeliveryInfoEntity, Integer> {
    List<DeliveryInfoEntity> findByLogin_idx(int loginIdx);

    @Query(value = "select * from deliveryinfo where delivery_idx=?1", nativeQuery = true)
    DeliveryInfoEntity findByDelivery_idx(int idx);
}
