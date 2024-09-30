package com.example.finalProject.dto;

import com.example.finalProject.entity.MiddleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MiddleDTO {
    private int idx;
    private String name;
    private int ref;

    public MiddleEntity toEntity(){
        return new MiddleEntity(idx,name,ref);
    }
}
