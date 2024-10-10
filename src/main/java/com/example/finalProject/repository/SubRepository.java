package com.example.finalProject.repository;

import com.example.finalProject.entity.SubEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubRepository extends JpaRepository<SubEntity,Integer> {
    @Query(value = "select * from sub where mod(ref div 100,10) = ?1 % 10 and ref div 1000 = ?1 div 100",nativeQuery = true)
    List<SubEntity> findByRef(int ref);
    @Query(value = "select * from sub where mod(ref div 100,10) = mod(?1 div 100,10) and ref div 1000 = ?1 div 1000",nativeQuery = true)
    List<SubEntity> findByRef2(int ref);
}
