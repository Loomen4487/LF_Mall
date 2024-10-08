package com.example.finalProject.service;

import com.example.finalProject.dto.OrderedDTO;
import com.example.finalProject.dto.ProductDTO;
import com.example.finalProject.dto.ReviewDTO;
import com.example.finalProject.dto.custom.ReviewAndOrderedDTO;
import com.example.finalProject.entity.OrderedEntity;
import com.example.finalProject.entity.ProductEntity;
import com.example.finalProject.entity.ReviewEntity;
import com.example.finalProject.repository.OrderedRepository;
import com.example.finalProject.repository.ProductRepository;
import com.example.finalProject.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final OrderedRepository orderedRepository;

    private final ProductRepository productRepository;
    @Transactional
    public void insert(ReviewDTO dto){
        OrderedEntity oe = orderedRepository.findByIdx(dto.getIdx());
        System.out.println("ReviewService insert : "+oe.toDTO());
        OrderedDTO od = oe.toDTO();
        od.setReview(true);
        orderedRepository.save(od.toEntity());
        reviewRepository.save(dto.toEntity());
    }

    // 주문한 상품중 리뷰를 안적은 상품들 불러오기
    public List<ReviewAndOrderedDTO> reviewAndOrderedSelectAll(String id){
        List<OrderedEntity> oe = orderedRepository.findByLogin_id(id);
        List<ReviewAndOrderedDTO> li = new ArrayList<>();
        for (OrderedEntity orderedEntity : oe) {
            ProductEntity pe = productRepository.findByIdx(orderedEntity.getProduct_idx());
            if(!orderedEntity.isReview()){
                ReviewAndOrderedDTO dto = new ReviewAndOrderedDTO(orderedEntity.getIdx(),pe.getIdx(),pe.getImage(),orderedEntity.getRegDate(),pe.getName());
                li.add(dto);

            }
        }
        return li;
    }

    public List<ReviewDTO> findAll(){
        List<ReviewEntity> re = reviewRepository.findAll();
        List<ReviewDTO> dto = new ArrayList<>();
        re.forEach(item->dto.add(item.toDTO()));
        return dto;
    }

    // 작성된 리뷰 가져오기
    public List<ReviewDTO> findByProduct_idx(int idx){
        List<ReviewEntity> re = reviewRepository.findByProduct_idx(idx);
        List<ReviewDTO> dto = new ArrayList<>();
        re.forEach(item->dto.add(item.toDTO()));
        return dto;
    }

    public List<ReviewDTO> selectByReviewLogin_id(String id){
        List<ReviewEntity> re = reviewRepository.selectByReviewLogin_id(id);
        List<ReviewDTO> dto = new ArrayList<>();
        for (ReviewEntity reviewEntity : re) {
            ProductEntity pe = productRepository.findByIdx(reviewEntity.getProduct_idx());
            ReviewDTO rd = reviewEntity.toDTO();
            rd.setProduct(pe.toDTO());
            dto.add(rd);
        }
        return dto;
    }

    // 리뷰 삭제
    @Transactional
    public void delete(int idx){
        ReviewEntity re = reviewRepository.findByIdx(idx);
        if(!Objects.isNull(re))reviewRepository.delete(re);
    }
}
