package com.example.finalProject.repository;

import com.example.finalProject.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<LoginEntity,Integer> {
    LoginEntity findById(String username);
    LoginEntity findByEmail(String email);

}
