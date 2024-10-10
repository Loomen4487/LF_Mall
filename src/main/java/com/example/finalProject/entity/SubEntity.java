package com.example.finalProject.entity;

import com.example.finalProject.dto.SubDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sub")
@AllArgsConstructor
@NoArgsConstructor
public class SubEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    private String name;

    private int ref;

    public SubDTO toDTO(){
        return new SubDTO(idx,name,ref);
    }
}
