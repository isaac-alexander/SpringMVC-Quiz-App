package com.alex.springMVC_Quiz.repository;

import com.alex.springMVC_Quiz.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
