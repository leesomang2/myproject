package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Grade;

public interface GradeRepository extends JpaRepository<Grade, Long> {
		
	@Query("select g from Grade g join fetch g.snum s where g.season = '1학기'")
    List<Grade> list();
	
}
