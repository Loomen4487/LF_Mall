package com.example.finalProject.dto;

import com.example.finalProject.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private int idx;
    private String major;
    private String middle;
    private String sub;
    private Date created_at;
    private Date updated_at;

    public CategoryEntity toEntity(){
        return new CategoryEntity(idx,major,middle,sub,created_at,updated_at);
    }
}