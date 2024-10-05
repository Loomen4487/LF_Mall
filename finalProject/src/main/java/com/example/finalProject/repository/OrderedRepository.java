package com.example.finalProject.repository;

import com.example.finalProject.entity.OrderedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderedRepository extends JpaRepository<OrderedEntity, Integer> {
    OrderedEntity findByPhone(String phone);
    OrderedEntity findByAddress(String address);
    OrderedEntity findByDetailAddress(String detailAddress);

    @Query(value = "select * from ordered where login_id=?1",nativeQuery = true)
    List<OrderedEntity> findByLogin_id(String id);
    @Query(value = "select * from ordered where product_idx=?1",nativeQuery = true)
    OrderedEntity findByProduct_idx(int idx);

    OrderedEntity findByIdx(int idx);
    @Query(value = "select count(*) from ordered where login_id=?1",nativeQuery = true)
    int selectCount(String id);

    // 마이페이지 주문 배송내역 날짜 조회
    @Query(value = "select * from ordered where date_add(regdate,interval ?1 month) < regdate",nativeQuery = true)
    public List<OrderedEntity> selectOrderedDateList(int time);

    // 마이페이지 취소/교환/환불신청 신청가능 내역 조회
    @Query(value = "select * from ordered where isdelivery=1 and login_id=?1",nativeQuery = true)
    List<OrderedEntity> selectCallbackList(String id);

}
