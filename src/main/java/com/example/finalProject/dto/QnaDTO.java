package com.example.finalProject.dto;

import com.example.finalProject.entity.QnaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QnaDTO {
    private int idx;
    private String title;
    private String content;
    private boolean isAnswer;
    private int product_idx;
    private String id;
    private Date regDate;

    public QnaEntity toEntity(){
        return new QnaEntity(idx,title,content,isAnswer,product_idx,id,regDate);
    }
}
