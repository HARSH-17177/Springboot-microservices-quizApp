package com.harsh.questionservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data //to eleminate the getter and setter code
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //here as id is primary key so we are using @id and @GeneratedValue to auto generated id value
    private Integer id;
    private String questionTitle; //here questionTitle will be represented as question_title in mysql therefore 'T' is used
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private String category;
    private String difficultylevel;

}


// also check the pgadmin4 table attributes properties that the id is identity or not if identity always where it is starting from