package com.example.controller;

import com.example.entity.Questions;
import com.example.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/question")
public class QuestionController {

    @Autowired
    QuestionService service;

    @GetMapping(path = "/allQuestions")
    public ResponseEntity<List<Questions>> getAllQuestions(){
        return service.getAllQuestions();
    }

    @GetMapping(path = "/category/{category}")
    public ResponseEntity<List<Questions>> findByCategory(@PathVariable String category){
        return service.findByCategory(category);
    }

    @PostMapping(path = "/postQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Questions question){
        return service.addQuestion(question);
    }

//    @DeleteMapping(path = "/delete/{quesId}")
//    public String deleteQuestion(int quesId){
//        return deleteQuestion(quesId);
//    }
}
