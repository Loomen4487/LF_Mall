package com.example.finalProject.dto;

import com.example.finalProject.entity.MajorEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MajorDTO {
    private int idx;
    private String name;
    private int ref;

    public MajorEntity toEntity(){
        return new MajorEntity(idx,name,ref);
    }
}
