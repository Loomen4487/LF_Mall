package com.example.finalProject.entity;

import com.example.finalProject.dto.NoticeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "notice")
@AllArgsConstructor
@NoArgsConstructor
public class NoticeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    private String subject;
    private String content;
    @CreationTimestamp
    private Date regDate;

    public NoticeDTO toDTO(){
        return new NoticeDTO(idx,subject,content,regDate);
    }
}
