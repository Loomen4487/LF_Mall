package com.example.finalProject.repository;

import com.example.finalProject.entity.DeliveryInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryInfoRepository extends JpaRepository<DeliveryInfoEntity, Integer> {
    List<DeliveryInfoEntity> findByLogin_idx(int loginIdx);
}
