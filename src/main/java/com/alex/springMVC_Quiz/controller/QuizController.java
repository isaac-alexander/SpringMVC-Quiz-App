package com.alex.springMVC_Quiz.controller;

import com.alex.springMVC_Quiz.entity.Question;
import com.alex.springMVC_Quiz.service.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("answers") // keeps answers across pages
public class QuizController {

    private QuizService quizService;

    // constructor
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/")
    public String startQuiz() {
        return "redirect:/question/0";
    }

    // create empty map to store answers
    @ModelAttribute("answers")
    public Map<Long, String> answers() {
        return new HashMap<>();
    }

    // show question
    @GetMapping("/question/{index}")
    public String showQuestion(@PathVariable int index, Model model) {

        List<Question> questions = quizService.getAllQuestions();

        // compares the question index with question size
        if (index >= questions.size()) {
            return "redirect:/question/0";
        }

        Question q = questions.get(index);

        model.addAttribute("question", q);
        model.addAttribute("index", index);
        model.addAttribute("total", questions.size());

        return "question";
    }



    // save answer and go to the next question
    @PostMapping("/question/{index}")
    public String nextQuestion(
            @PathVariable int index,
            @RequestParam String answer,
            @ModelAttribute("answers") Map<Long, String> answers,
            Model model) {

        List<Question> questions = quizService.getAllQuestions();

        Question q = questions.get(index);

        // save answer
        answers.put(q.getId(), answer);

        // last question then calculate result
        if (index == questions.size() - 1) {

            int score = quizService.calculateScore(answers);
            model.addAttribute("score", score);

            return "result";
        }

        // go to next question
        return "redirect:/question/" + (index + 1);
    }
}