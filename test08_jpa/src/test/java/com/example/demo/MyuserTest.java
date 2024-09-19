package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.example.demo.entity.Myuser;
import com.example.demo.repository.MyuserRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Transactional
@Rollback(value = false)
@Slf4j
public class MyuserTest {
	@Autowired
	MyuserRepository mu;

	@Test
	void save() {
		Myuser user = mu.save(new Myuser("user3", "3333", "user3@", null, null));
		log.info("user-->", user);
	}

	@Test
	void update() {
//		Myuser user = new Myuser("user2", "3456", "user22@", null, null);
		Optional<Myuser> user1 = mu.findById("user2");
		if (!user1.isEmpty()) {
			Myuser my = user1.get();
			my.setPassword("2456");
			my.setEmail("user23@");
		}
	}
	
	@Test
	void delete(){
		mu.deleteById("user2");
	}
	
	@Test
	void selectAll() {
		List<Myuser> list = mu.findAll();
		list.forEach(m->System.out.println(m));
	}
	

}
