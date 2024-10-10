package com.example.finalProject.repository;

import com.example.finalProject.entity.CategoryEntity;
import com.example.finalProject.entity.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    @Query(value = "select distinct middle from category where major = ?1",nativeQuery = true)
    List<String> selectMajor(String major);

    @Query(value = "select distinct sub from category where middle = ?1",nativeQuery = true)
    List<String> selectmiddle(String middle);

    NoticeEntity findByIdx(int idx);
}
