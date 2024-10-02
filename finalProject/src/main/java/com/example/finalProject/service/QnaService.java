package com.example.finalProject.service;

import com.example.finalProject.dto.QnaDTO;
import com.example.finalProject.entity.QnaEntity;
import com.example.finalProject.repository.QnaRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QnaService {
    private final QnaRepository qnaRepository;
    public QnaDTO findByIdx(int idx){
        return qnaRepository.findByIdx(idx).toDTO();
    }

    public void insert(QnaDTO dto){
        qnaRepository.save(dto.toEntity());
    }

    public List<QnaDTO> findAll(){
        List<QnaEntity> qe = qnaRepository.findAll();
        List<QnaDTO> dto = new ArrayList<>();
        qe.forEach(item->dto.add(item.toDTO()));
        return dto;
    }
    // qna 상품별 가져오기
    public List<QnaDTO> findByProduct_idx(int idx){
        List<QnaEntity> qe = qnaRepository.findByProduct_idx(idx);
        List<QnaDTO> dto = new ArrayList<>();
        qe.forEach(item->dto.add(item.toDTO()));
        return dto;
    }

    @Transactional
    public void update(QnaDTO dto){
        qnaRepository.update(dto.toEntity());
    }
}
