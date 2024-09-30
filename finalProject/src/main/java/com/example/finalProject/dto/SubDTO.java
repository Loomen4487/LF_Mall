package com.example.finalProject.dto;

import com.example.finalProject.entity.SubEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubDTO {
    private int idx;
    private String name;
    private int ref;

    public SubEntity toEntity(){
        return new SubEntity(idx,name,ref);
    }
}
