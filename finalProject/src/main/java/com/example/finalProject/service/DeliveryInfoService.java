package com.example.finalProject.service;

import com.example.finalProject.dto.DeliveryInfoDTO;
import com.example.finalProject.entity.DeliveryInfoEntity;
import com.example.finalProject.entity.LoginEntity;
import com.example.finalProject.repository.DeliveryInfoRepository;
import com.example.finalProject.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
