package com.example.finalProject.service;

import com.example.finalProject.dto.OrderedDTO;
import com.example.finalProject.entity.OrderedEntity;
import com.example.finalProject.repository.OrderedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderedService {
    private final OrderedRepository orderedRepository;

    public void insert(OrderedDTO orderedDTO) {
        orderedRepository.save(orderedDTO.toEntity());
    }
}
