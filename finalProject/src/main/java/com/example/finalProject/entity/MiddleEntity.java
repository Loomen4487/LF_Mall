package com.example.finalProject.entity;

import com.example.finalProject.dto.MiddleDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "middle")
@AllArgsConstructor
@NoArgsConstructor
public class MiddleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    private String name;

    private int ref;

    public MiddleDTO toDTO(){
        return new MiddleDTO(idx,name,ref);
    }
}
