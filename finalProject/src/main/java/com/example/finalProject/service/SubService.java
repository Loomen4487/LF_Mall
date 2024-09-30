package com.example.finalProject.service;

import com.example.finalProject.dto.SubDTO;
import com.example.finalProject.entity.SubEntity;
import com.example.finalProject.repository.SubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubService {

    private final SubRepository subRepository;

    public List<SubDTO> findByRef(int ref){
        List<SubEntity> se = subRepository.findByRef(ref);
        List<SubDTO> dto = new ArrayList<>();
        se.forEach(item->dto.add(item.toDTO()));
        return dto;
    }
}
