package com.harsh.questionservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harsh.questionservice.model.Question;
import com.harsh.questionservice.model.QuestionWrapper;
import com.harsh.questionservice.model.Response;
import com.harsh.questionservice.service.QuestionService;

@RestController //as here we want to accept the request
@RequestMapping("question")
public class QuestionController {

    @Autowired
QuestionService questionService;

@Autowired
Environment environment;  //used to show port of current instance

    @GetMapping("allQuestions")
    public  ResponseEntity<List<Question>> getAllQuestions()//here we along with data also showing the status code using ResponseEntity<>() here we dont have to again return REsponse Entity as we already returning in service class
    {
return questionService.getAllQuestions();
    }



    @GetMapping("category/{category}") //here {category} is the variable which would be stored in Pathvariable 
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) //here from url we are getting the request which may be category/java or category/python etc therefore for handling the requestion which will come as variable {category} We define Path variable where we store the requested value
    {
return questionService.getQuestionsByCategory(category);
    }








    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question)
    {
       return questionService.addQuestion(question);
        
    }


    @DeleteMapping("delete/{id}")
    public String deleteQuestion(@PathVariable Integer id)
    {
return questionService.deleteQuestion(id);
    }
// generate
// getQuestions(questionid)
// getScore

@GetMapping("generate")
public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName,@RequestParam Integer numQuestions){
return questionService.getQuestionsForQuiz(categoryName,numQuestions);
}

@PostMapping("getQuestions")
public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds)
{
    System.out.println(environment.getProperty("local.server.port")); //used to print instance port on console whic shows openFeign is providing task to which task by load balancing
    return questionService.getQuestionsFromId(questionIds);
}

@PostMapping("getScore")
public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses)
{
return questionService.getScore(responses);
}

}




