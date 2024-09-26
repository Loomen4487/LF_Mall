package com.example.finalProject.entity;

import com.example.finalProject.dto.CategroyDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
public class CategroyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    private String majar;
    private String middle;
    private String sub;

    public CategroyDTO toDTO() {
        return new CategroyDTO(idx,majar,middle,sub);
    }
}
