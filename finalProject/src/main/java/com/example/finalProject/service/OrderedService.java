package com.example.finalProject.service;

import com.example.finalProject.dto.OrderedDTO;
import com.example.finalProject.dto.ProductDTO;
import com.example.finalProject.entity.OrderedEntity;
import com.example.finalProject.entity.ProductEntity;
import com.example.finalProject.repository.OrderedRepository;
import com.example.finalProject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderedService {
    private final OrderedRepository orderedRepository;
    private final ProductRepository productRepository;
    public void insert(OrderedDTO orderedDTO) {
        orderedRepository.save(orderedDTO.toEntity());
    }

    // 마이페이지 리뷰 작성가능한 주문 불러오기
    public List<OrderedDTO> findByLogin_id(String id){
        List<OrderedEntity> oe = orderedRepository.findByLogin_id(id);
        List<OrderedDTO> dto = new ArrayList<>();
        for (OrderedEntity orderedEntity : oe) {
            OrderedDTO od = orderedEntity.toDTO();
            ProductEntity pe = productRepository.findByIdx(orderedEntity.getProduct_idx());
            od.setProduct(pe.toDTO());
            dto.add(od);
        }
        return dto;
    }

    public void delete(int idx){
        OrderedEntity oe = orderedRepository.findByIdx(idx);
        orderedRepository.delete(oe);
    }

    public int selectCount(String id){
        return orderedRepository.selectCount(id);
    }

    public List<OrderedDTO> selectOrderedDateList(int time){
        List<OrderedEntity> oe = orderedRepository.selectOrderedDateList(time*(-1));
        List<OrderedDTO> dto = new ArrayList<>();
        for (OrderedEntity orderedEntity : oe) {
            ProductEntity pe = productRepository.findByIdx(orderedEntity.getProduct_idx());
            OrderedDTO od = orderedEntity.toDTO();
            od.setProduct(pe.toDTO());
            dto.add(od);
        }
        return dto;
    }

    // 취소/교환/환불신청 총 개수 세기
    public List<OrderedDTO> selectCallbackList(String id){
        List<OrderedEntity> oe =  orderedRepository.selectCallbackList(id);
        List<OrderedDTO> dto = new ArrayList<>();
        for (OrderedEntity orderedEntity : oe) {
            ProductEntity pe = productRepository.findByIdx(orderedEntity.getProduct_idx());
            OrderedDTO od = orderedEntity.toDTO();
            od.setProduct(pe.toDTO());
            dto.add(od);
        }
        return dto;
    }
}
