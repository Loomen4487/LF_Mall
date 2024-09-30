package com.example.finalProject.entity;

import com.example.finalProject.dto.MajorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "major")
@AllArgsConstructor
@NoArgsConstructor
public class MajorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    private String name;
    private int ref;

    public MajorDTO toDTO(){
        return new MajorDTO(idx,name,ref);
    }
}
