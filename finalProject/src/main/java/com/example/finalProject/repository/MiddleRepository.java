package com.example.finalProject.repository;

import com.example.finalProject.entity.MiddleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MiddleRepository extends JpaRepository<MiddleEntity,Integer> {
    @Query(value = "select * from middle where ref div 100 = ?1",nativeQuery = true)
    List<MiddleEntity> findByRef(int ref);

    @Query(value = "select * from middle where ref=?1",nativeQuery = true)
    MiddleEntity selectByRef(int ref);

    // 중분류 이름 저장
    @Query(value = "select * from middle where concat(ref div 100,ref%10) = ?1 div 100",nativeQuery = true)
    MiddleEntity selectByMiddleRef(int idx);
}
