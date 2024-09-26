package com.example.finalProject.repository;

import com.example.finalProject.entity.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoticeRepository extends JpaRepository<NoticeEntity,Integer> {
    @Query(value = "select * from notice limit ?1,?2",nativeQuery = true)
    List<NoticeEntity> selectAll(int startNo,int size);

    @Query(value = "select count(*) from notice",nativeQuery = true)
    int selectCount();

    NoticeEntity findByIdx(int idx);

}
