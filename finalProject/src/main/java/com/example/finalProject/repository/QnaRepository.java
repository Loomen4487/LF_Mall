package com.example.finalProject.repository;

import com.example.finalProject.entity.QnaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QnaRepository extends JpaRepository<QnaEntity,Integer> {
    QnaEntity findByIdx(int idx);
    @Query(value = "select * from qna where product_idx=?1",nativeQuery = true)
    List<QnaEntity> findByProduct_idx(int idx);

    @Modifying
    @Query(value = "update qna set content=:#{#qe.content},regdate=now(),isanswer=:#{#qe.isAnswer} where idx=:#{#qe.idx}",nativeQuery = true)
    void update(@Param("qe") QnaEntity qe);
}
