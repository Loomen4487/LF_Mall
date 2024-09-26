package com.example.finalProject.repository;

import com.example.finalProject.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
    @Query(value = "select * from product where category_idx = ?1",nativeQuery = true)
    List<ProductEntity> selectIdx(int idx);

    @Query(value = "select * from product where category_idx=1 order by rand() limit 6",nativeQuery = true)
    List<ProductEntity> recommandProduct();

    ProductEntity findByIdxAndCategory_idx(int idx,int category_idx);

    @Query(value = "select p.*,c.middle from product p,category c where c.idx=p.category_idx and p.category_idx in (select idx from category c where major =?1)",nativeQuery = true)
    List<ProductEntity> selectMajor(String name);

    @Query(value = "select p.*,c.sub from product p,category c where p.category_idx = c.idx and category_idx in (select idx from category c where major =?1 and middle like ?2)",nativeQuery = true)
    List<ProductEntity> selectMiddle(String major,String middle);

    @Query(value = "select * from product p where category_idx in (select idx from category c where major =?1 and middle like ?2 and sub=?3)",nativeQuery = true)
    List<ProductEntity> selectSub(String major,String middle,String sub);
}
