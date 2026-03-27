package com.alex.springMVC_Quiz.service.impl;

import com.alex.springMVC_Quiz.entity.Question;
import com.alex.springMVC_Quiz.repository.QuestionRepository;
import com.alex.springMVC_Quiz.service.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service // service class/business logic
public class QuizServiceImpl implements QuizService {

    private  QuestionRepository questionRepository; // database access

    // Constructor injection
    public QuizServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }
//
//    @Override
//    public Question getQuestionById(Long id) {
//        return questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question not found"));
//    }

    // Get all questions
    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    // Calculate score

    @Override
    public int calculateScore(Map<Long, String> answers) {

        int score = 0; // intialize score

        // get all questions from database
        List<Question> questions = questionRepository.findAll();

        // Loop through each question
        for (Question q : questions) {
            //gets user answer using questionId
            String userAnswer = answers.get(q.getId());

            //  Compare user answer with correct answer
            if (userAnswer != null && userAnswer.equals(q.getCorrectAnswer())) {
                score++;
            }
        }

        // return final score
        return score;
    }
}
