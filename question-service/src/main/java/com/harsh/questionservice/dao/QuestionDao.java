package com.harsh.questionservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//all handling of data from database would be done by jpa JpaRepository<class name,primarykey>
import org.springframework.data.jpa.repository.Query;

import com.harsh.questionservice.model.Question;
public interface QuestionDao extends JpaRepository<Question,Integer>{
    
   List<Question> findByCategory(String category);

   @Query(value = "select q.id from question q where q.category=:category order by RANDOM() limit :numQ",nativeQuery = true)
List<Integer> findRandomQuestionByCategory(String category, int numQ);//here we are returnning the id of random questions

}
