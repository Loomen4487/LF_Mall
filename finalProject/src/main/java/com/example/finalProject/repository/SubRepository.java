package com.example.finalProject.repository;

import com.example.finalProject.entity.SubEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubRepository extends JpaRepository<SubEntity,Integer> {
    @Query(value = "select * from sub where mod(ref,1000) div 100 = ?1",nativeQuery = true)
    List<SubEntity> findByRef(int ref);
}
