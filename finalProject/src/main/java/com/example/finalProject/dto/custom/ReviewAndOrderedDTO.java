package com.example.finalProject.dto.custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewAndOrderedDTO {
    private int idx;
    private int product_idx;
    private String image;
    private Date regDate;
    private String name;
}
