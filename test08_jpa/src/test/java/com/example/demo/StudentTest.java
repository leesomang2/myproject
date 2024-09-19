package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Transactional
@Rollback(value=false)
@Slf4j
public class StudentTest {
	@Autowired StudentRepository sr;

	@Test
	void save() {
		Student student = sr.save(new Student(2L, "삼소망", "012-1234"));
		log.info("student-->", student);
	}
	
}
