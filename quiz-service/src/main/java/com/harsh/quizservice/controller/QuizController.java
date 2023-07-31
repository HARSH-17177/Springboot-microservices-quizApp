package com.harsh.quizservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.harsh.quizservice.model.QuestionWrapper;
import com.harsh.quizservice.model.QuizDTO;
import com.harsh.quizservice.model.Response;
import com.harsh.quizservice.service.QuizService;



@RestController
@RequestMapping("quiz")
public class QuizController {

@Autowired
QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDTO quizdto){  //instead of 3 parameters using one object as a Data transfer object
return  quizService.createQuiz(quizdto.getCategoryName(),quizdto.getNumQuestions(),quizdto.getTitle());
    }


@GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id)
    {
return quizService.getQuizQuestion(id);
    }

@PostMapping("submit/{id}")
public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> response)    
{
return quizService.calculateResult(id,response);
}
}


// http://localhost:8080/quiz/create?category=Java&numQ=5&title=JQuiz                 for creating quiz

// http://localhost:8080/quiz/submit/1             for submitting answers of question we got form above api link
// [
// {
//     "id":2,
//     "response":"5"
// },
// {
//     "id":4,
//     "response":"throw"
// },
// {
//     "id":5,
//     "response":"final int x = 5;"
// },
// {
//     "id":13,
//     "response":"Math.PI"
// },
// {
//     "id":9,
//     "response":"-"
// }
// ]