package com.example.finalProject.repository;

import com.example.finalProject.entity.OrderedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderedRepository extends JpaRepository<OrderedEntity, Integer> {
    OrderedEntity findByPhone(String phone);
    OrderedEntity findByAddress(String address);
    OrderedEntity findByDetailAddress(String detailAddress);

    @Query(value = "select * from ordered where login_id=?1",nativeQuery = true)
    List<OrderedEntity> findByLogin_id(String id);
}
