package com.blacode.quizapp.config;

import com.blacode.quizapp.dao.QuestionDao;
import com.blacode.quizapp.dao.QuizDao;
import com.blacode.quizapp.model.Question;
import com.blacode.quizapp.model.Quiz;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class Seeder {
    @Autowired
    private QuestionDao questionRepository;
    @Autowired
    private QuizDao quizRepository;

    @Bean
    CommandLineRunner seedDatabase() {
        return args -> {

            if (questionRepository.count() > 0) return; // avoid duplicates

            Question q1 = new Question();
            q1.setQuestionTitle("What is Java?");
            q1.setOption1("Programming Language");
            q1.setOption2("OS");
            q1.setOption3("Browser");
            q1.setOption4("Database");
            q1.setRightAnswer("Programming Language");
            q1.setDifficultylevel("EASY");
            q1.setCategory("Java");

            Question q2 = new Question();
            q2.setQuestionTitle("What is Spring Boot?");
            q2.setOption1("Framework");
            q2.setOption2("Library");
            q2.setOption3("Language");
            q2.setOption4("IDE");
            q2.setRightAnswer("Framework");
            q2.setDifficultylevel("MEDIUM");
            q2.setCategory("Spring");

            questionRepository.saveAll(List.of(q1, q2));

            Quiz quiz = new Quiz();
            quiz.setTitle("Java Starter Quiz");
            quiz.setQuestions(List.of(q1, q2));

            quizRepository.save(quiz);
        };
    }
}