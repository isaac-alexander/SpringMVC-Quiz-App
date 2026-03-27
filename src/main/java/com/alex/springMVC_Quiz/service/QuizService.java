package com.alex.springMVC_Quiz.service;

import com.alex.springMVC_Quiz.entity.Question;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface QuizService {

//    Question getQuestionById(Long id);

    // Method to get all questions
    List<Question> getAllQuestions();

    // Calculate score from submitted answers
    int calculateScore(Map<Long, String> answers);
}
