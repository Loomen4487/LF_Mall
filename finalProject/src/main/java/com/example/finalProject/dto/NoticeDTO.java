package com.example.finalProject.dto;

import com.example.finalProject.entity.NoticeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDTO {
    private int idx;
    private String subject;
    private String content;
    private Date regDate;

    public NoticeEntity toEntity(){
        return new NoticeEntity(idx,subject,content,regDate);
    }
}
