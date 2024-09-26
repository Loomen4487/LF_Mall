package com.example.finalProject.dto;

import com.example.finalProject.entity.CategroyEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategroyDTO {
    private int idx;
    private String major;
    private String middle;
    private String sub;

    public CategroyEntity toEntity() {
        return new CategroyEntity(idx,major,middle,sub);
    }
}
