package com.harsh.quizservice.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.harsh.quizservice.dao.QuizDao;
import com.harsh.quizservice.feign.QuizInterface;
import com.harsh.quizservice.model.QuestionWrapper;
import com.harsh.quizservice.model.Quiz;
import com.harsh.quizservice.model.Response;


@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
   
      List<Integer> questions =quizInterface.getQuestionsForQuiz(category, numQ).getBody();
      Quiz quiz=new Quiz();
      quiz.setTitle(title);
      quiz.setQuestionIds(questions);
      quizDao.save(quiz);//to save quiz in the database
      


      return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
       Quiz quiz= quizDao.findById(id).get(); 
List<Integer> questionIds =quiz.getQuestionIds();
ResponseEntity<List<QuestionWrapper>> questionForUser=quizInterface.getQuestionsFromId(questionIds);
return questionForUser;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
      ResponseEntity<Integer> score =quizInterface.getScore(responses);
return score;
    }

   
    
}
