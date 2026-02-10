package com.blacode.quizapp.controller;

import com.blacode.quizapp.model.QuestionWrapper;
import com.blacode.quizapp.model.Response;
import com.blacode.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {


//    Create
//     quiz => mapping =>
//     RequestParam (String category ,int numQ ,String title )


    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz
            (
            @RequestParam String category,
            @RequestParam int numQ,
            @RequestParam String title
            )
    {
        return quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id) {
        return quizService.getQuizQuestion(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id , @RequestBody List<Response> response){
        return quizService.calculateResult(id,response);
    }
}
