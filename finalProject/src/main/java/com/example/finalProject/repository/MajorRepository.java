package com.example.finalProject.repository;

import com.example.finalProject.entity.MajorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MajorRepository extends JpaRepository<MajorEntity,Integer> {

    MajorEntity findByRef(int ref);
}
