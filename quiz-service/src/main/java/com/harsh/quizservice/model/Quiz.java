package com.harsh.quizservice.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Quiz {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String title;

@ElementCollection //here we dont have many to many because we dont need to map lot of data as only list of integer is there
private List<Integer> questionIds;
}
