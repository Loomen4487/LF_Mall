package com.example.finalProject.service;

import com.example.finalProject.dto.MajorDTO;
import com.example.finalProject.entity.MajorEntity;
import com.example.finalProject.repository.MajorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MajorService {
    private final MajorRepository majorRepository;

    public MajorDTO findByRef(int ref){
        MajorEntity me = majorRepository.findByRef(ref);
        return me.toDTO();
    }
    public List<MajorDTO> findAll(){
        List<MajorEntity> me = majorRepository.findAll();
        List<MajorDTO> dto = new ArrayList<>();
        me.forEach(item->dto.add(item.toDTO()));
        return dto;
    }
}
