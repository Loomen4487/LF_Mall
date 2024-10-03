package com.example.finalProject.dto.custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewAndOrderedDTO {
    private String image;
    private Date regDate;
    private String name;
}
