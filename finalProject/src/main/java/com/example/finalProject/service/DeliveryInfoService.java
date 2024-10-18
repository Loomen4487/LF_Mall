package com.example.finalProject.service;

import com.example.finalProject.dto.DeliveryInfoDTO;
import com.example.finalProject.entity.DeliveryInfoEntity;
import com.example.finalProject.entity.LoginEntity;
import com.example.finalProject.repository.DeliveryInfoRepository;
import com.example.finalProject.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeliveryInfoService {
    private final DeliveryInfoRepository deliveryInfoRepository;
    private final LoginRepository loginRepository;

    public void insetDeliveryInfo(DeliveryInfoDTO deliveryInfoDTO) {
        LoginEntity loginEntity = loginRepository.findById(deliveryInfoDTO.getLogin_idx()).orElse(null);
        deliveryInfoRepository.save(deliveryInfoDTO.toEntity(loginEntity));
    }

    // 사용자의 모든 배송지 정보를 가져오기
    public List<DeliveryInfoDTO> findDeliveryInfosByLoginIdx(int loginIdx) {
        return deliveryInfoRepository.findByLogin_idx(loginIdx)
                .stream()
                .map(DeliveryInfoEntity::toDTO)
                .collect(Collectors.toList());
    }


    // 배송지 수정 메서드
    public void updateDeliveryInfo(DeliveryInfoDTO deliveryInfoDTO) {
        // 기존 배송지 정보 가져오기
        Optional<DeliveryInfoEntity> deliveryInfoOptional = deliveryInfoRepository.findById(deliveryInfoDTO.getDelivery_idx());

        if (deliveryInfoOptional.isPresent()) {
            DeliveryInfoEntity deliveryInfoEntity = deliveryInfoOptional.get();

            // 수정된 정보 설정
            deliveryInfoEntity.setReceiver(deliveryInfoDTO.getReceiver());
            deliveryInfoEntity.setPhone(deliveryInfoDTO.getPhone());
            deliveryInfoEntity.setAddress(deliveryInfoDTO.getAddress());
            deliveryInfoEntity.setDetailAddress(deliveryInfoDTO.getDetailAddress());

            // DB에 저장
            deliveryInfoRepository.save(deliveryInfoEntity);
        }
    }


    // 배송지 삭제 메서드
    public void deleteDeliveryInfo(@PathVariable("deliveryIdx") int deliveryIdx) {
        // 해당 배송지 정보가 존재하는지 확인
        Optional<DeliveryInfoEntity> deliveryInfoOptional = deliveryInfoRepository.findById(deliveryIdx);

        if (deliveryInfoOptional.isPresent()) {
            // 배송지 삭제
            deliveryInfoRepository.deleteById(deliveryIdx);
        }
    }

    @Transactional
    public void deleteAllDeliveryInfoByLogin(String username) {
        // 로그인된 사용자 정보 직접 검색
        LoginEntity loginEntity = loginRepository.findById(username);

        if (loginEntity != null) {
            // 값이 존재하면 처리
            deliveryInfoRepository.deleteByLogin(loginEntity);
        } else {
            // 값이 없으면 예외 처리
            throw new UsernameNotFoundException("User not found");
        }
    }

    public DeliveryInfoDTO findByIdx(int idx) {
        DeliveryInfoEntity deliveryInfoOptional = deliveryInfoRepository.findByDelivery_idx(idx);

        return deliveryInfoOptional.toDTO();
    }
}
