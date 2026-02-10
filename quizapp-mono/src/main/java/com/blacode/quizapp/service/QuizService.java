package com.blacode.quizapp.service;


import com.blacode.quizapp.dao.QuestionDao;
import com.blacode.quizapp.dao.QuizDao;
import com.blacode.quizapp.model.Question;
import com.blacode.quizapp.model.QuestionWrapper;
import com.blacode.quizapp.model.Quiz;
import com.blacode.quizapp.model.Response;
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
    QuestionDao questionDao;
    @Autowired
    QuizDao quizDao;

    public ResponseEntity<String> createQuiz (String category, int numQ, String title){
        List<Question> questions = questionDao.findRandomQuestionsByCategory(category,numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionFromDb = quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser = new ArrayList<>();
        for(Question q : questionFromDb){
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionForUser.add(qw);
        }

        return new ResponseEntity<>(questionForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
        List<Question> questions = quiz.getQuestions();
        int right = 0;
        int i = 0;
        for(Response response : responses){
            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;

            i++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);

    }
}
