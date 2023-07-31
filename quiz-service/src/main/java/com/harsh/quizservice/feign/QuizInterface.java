package com.harsh.quizservice.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.harsh.quizservice.model.QuestionWrapper;
import com.harsh.quizservice.model.Response;
                                //Feign dependency will automatically do the task of load baancing between instances
@FeignClient("QUESTION-SERVICE")//mention the service we want to connect
public interface QuizInterface {
    @GetMapping("question/generate")
public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName,@RequestParam Integer numQuestions);
@PostMapping("question/getQuestions")
public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds);


@PostMapping("question/getScore")
public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);


    
}
