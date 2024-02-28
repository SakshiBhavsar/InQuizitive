package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity(name = "quiz_app")
@Table
public class Questions {

    @Id
    @Column(name = "ques_id")
    int quesId;

    @Column(name = "category")
    String category;

    @Column(name = "difficulty_level")
    String difficultyLevel;

    @Column(name = "question")
    String question;

    @Column(name = "option1")
    String option1;

    @Column(name = "option2")
    String option2;

    @Column(name = "option3")
    String option3;

    @Column(name = "option4")
    String option4;

    @Column(name = "right_answer")
    String rightAnswer;

}
