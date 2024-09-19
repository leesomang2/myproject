package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.example.demo.entity.Grade;
import com.example.demo.entity.Student;
import com.example.demo.repository.GradeRepository;
import com.example.demo.repository.StudentRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class GradeTest {
	@Autowired
	StudentRepository sr;
	@Autowired
	GradeRepository gr;

	@Test
	void save() {
		Optional<Student> s = sr.findById(2L); // myuser 테이블에있는 username꺼내와서 넣어주기

		if (!s.isEmpty()) {
			Student s1 = s.get();
			gr.save(new Grade(0L, s1, "수학", "100", "1학기"));
			gr.save(new Grade(0L, s1, "과학", "60", "1학기"));
			gr.save(new Grade(0L, s1, "국어", "20", "1학기"));
		}

	}
	
	@Test
	void list() {
		List<Grade> list = gr.list();
		list.forEach(g -> {
			System.out.println("학생번호: " + g.getSnum().getSnum()); // 학생번호 snum
			System.out.println("이름: " + g.getSnum().getSname()); // 학생이름 sname
			System.out.println("과목명: " + g.getGname()); // 과목명 gname
			System.out.println("점수: " + g.getScore()); // 점수 score
		});
	}
}
