package com.example.finalProject.repository;

import com.example.finalProject.entity.OrderedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedRepository extends JpaRepository<OrderedEntity, Integer> {
    OrderedEntity findByPhone(String phone);
    OrderedEntity findByAddress(String address);
    OrderedEntity findByDetailAddress(String detailAddress);
}
