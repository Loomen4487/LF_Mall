package com.example.finalProject.service;

import com.example.finalProject.dto.OrderedDTO;
import com.example.finalProject.entity.OrderedEntity;
import com.example.finalProject.repository.OrderedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderedService {
    private final OrderedRepository orderedRepository;

    public void insert(OrderedDTO orderedDTO) {
        orderedRepository.save(orderedDTO.toEntity());
    }

    // 마이페이지 리뷰 작성가능한 주문 불러오기
    public List<OrderedDTO> findByLogin_id(String id){
        List<OrderedEntity> oe = orderedRepository.findByLogin_id(id);
        List<OrderedDTO> dto = new ArrayList<>();
        oe.forEach(item->dto.add(item.toDTO()));
        return dto;
    }
}
