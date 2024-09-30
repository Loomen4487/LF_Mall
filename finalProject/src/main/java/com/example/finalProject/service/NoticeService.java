package com.example.finalProject.service;

import com.example.finalProject.dto.NoticeDTO;
import com.example.finalProject.entity.NoticeEntity;
import com.example.finalProject.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;
    public List<NoticeDTO> selectAll(int startNo,int size){
        List<NoticeEntity> ne = noticeRepository.selectAll(startNo,size);
        List<NoticeDTO> dto = new ArrayList<>();
        ne.forEach(item->dto.add(item.toDTO()));
        return dto;
    }

    public int selectCount(){
        return noticeRepository.selectCount();
    }

    public NoticeDTO selectByIdx(int idx){
        NoticeEntity ne = noticeRepository.findByIdx(idx);
        return ne.toDTO();
    }


}
