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

        // gets one question with the index and saves to the variable q
        Question q = questions.get(index);

        // sends question to the html
        model.addAttribute("question", q);
        // send question position of question to the html used in the form and button to navigate
        model.addAttribute("index", index);
        // sends total number of questions to the html used in the form and button to navigate
        model.addAttribute("total", questions.size());

        return "question";
    }



    // save answer and go to the next question
    @PostMapping("/question/{index}")
    public String nextQuestion(
            @PathVariable int index,
            @RequestParam String answer, // gets selected answer from form "A", "B", "C"
            @ModelAttribute("answers") Map<Long, String> answers, // gets stored answers map
            Model model) {

        List<Question> questions = quizService.getAllQuestions();

        // gets current question again
        Question q = questions.get(index);

        // save answer
        answers.put(q.getId(), answer);

        // last question then calculate result
        if (index == questions.size() - 1) {

            // calls calculate score Method in service
            int score = quizService.calculateScore(answers);
            model.addAttribute("score", score);

            return "result";
        }

        // go to next question
        return "redirect:/question/" + (index + 1);
    }
}