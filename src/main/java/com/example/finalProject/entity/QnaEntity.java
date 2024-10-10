package com.example.finalProject.entity;

import com.example.finalProject.dto.QnaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "qna")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class QnaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    private String title;
    private String content;
    @Column(name = "isanswer")
    private boolean isAnswer;
    private int product_idx;
    private String id;
    @CreationTimestamp
    private Date regDate;

    public QnaDTO toDTO(){
        return new QnaDTO(idx,title,content,isAnswer,product_idx,id,regDate);
    }
}
