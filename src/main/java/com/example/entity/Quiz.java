package com.example.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity(name = "quiz")
@Table
public class Quiz {

    @Id
    @Column(name = "quiz_id")
    Integer id;

    @Column(name = "quiz_title")
    String quizTitle;

    @ManyToMany
    @Column(name = "quiz_questions")
    List<Questions> questionsList;

}
