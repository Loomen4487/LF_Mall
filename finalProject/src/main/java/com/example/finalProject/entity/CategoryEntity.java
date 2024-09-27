package com.example.finalProject.entity;

import com.example.finalProject.dto.CategoryDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    private String major;
    private String middle;
    private String sub;
    private Date created_at;
    private Date updated_at;

    public CategoryDTO toDTO(){
        return new CategoryDTO(idx,major,middle,sub,created_at,updated_at);
    }
}
