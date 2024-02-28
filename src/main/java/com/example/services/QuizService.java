package com.example.services;

import com.example.entity.QuestionWrapper;
import com.example.entity.Questions;
import com.example.entity.Quiz;
import com.example.entity.Response;
import com.example.repo.QuestionRepo;
import com.example.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepo quizRepo;

    @Autowired
    QuestionRepo questionRepo;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Questions> questionsList = questionRepo.findRandomQuestionByCategory(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setQuizTitle(title);
        quiz.setQuestionsList(questionsList);
        quizRepo.save(quiz);

        return new ResponseEntity<>("SUCCESS!", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id){
        Optional<Quiz> quiz = quizRepo.findById(id);
        List<Questions> questionsFromDB = quiz.get().getQuestionsList();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();
        for(Questions q : questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getQuesId(), q.getQuestion(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionsForUser.add(qw);
        }
        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizRepo.findById(id).get();
        List<Questions> questionsList = quiz.getQuestionsList();
        int correctAns = 0;
        int i = 0;
        for(Response response : responses){
            if(response.getResponse().equals(questionsList.get(i).getRightAnswer()))
                correctAns++;
            i++;
        }
        return new ResponseEntity<>(correctAns, HttpStatus.OK);
    }
}
