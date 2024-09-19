package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.example.demo.dto.BoardDto;
import com.example.demo.entity.Board;
import com.example.demo.entity.Myuser;
import com.example.demo.repository.BoardRepository;
import com.example.demo.repository.MyuserRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
@Rollback(value=false)
public class BoardTest {
	@Autowired BoardRepository br;
	@Autowired MyuserRepository mr;
	
	@Test
	void save() {
		Optional<Myuser> mu = mr.findById("user2"); //myuser 테이블에있는 username꺼내와서 넣어주기
		if(!mu.isEmpty()) {
			Myuser myuser = mu.get();
			br.save(new Board(0L,myuser,"이","이",null));
			br.save(new Board(0L,myuser,"이이...","이이",null));
			br.save(new Board(0L,myuser,"이이이...","이이이",null));
		}
	}
	
	@Test
	void listAll() {
		List<Board> list = br.findAll();
		list.forEach(board->{
			System.out.println("글번호 :" + board.getNum());
			System.out.println("작성자 :" + board.getUser().getUsername());
			System.out.println("제목 :" + board.getTitle());
			System.out.println("내용 :" + board.getContent());
			System.out.println("작성일 :" + board.getRegdate());
		});
	}
	
	@Test
	void list1() {
		List<Board> list = br.list1();
		list.forEach(board->{
			System.out.println("글번호 :" + board.getNum());
			System.out.println("작성자 :" + board.getUser().getUsername());
			System.out.println("제목 :" + board.getTitle());
			System.out.println("내용 :" + board.getContent());
			System.out.println("작성일 :" + board.getRegdate());
		});
	}
	
	@Test
	void list2() {
		List<Board> list = br.list2("user2");
		list.forEach(board->{
			System.out.println("글번호 :" + board.getNum());
			System.out.println("작성자 :" + board.getUser().getUsername());
			System.out.println("제목 :" + board.getTitle());
			System.out.println("내용 :" + board.getContent());
			System.out.println("작성일 :" + board.getRegdate());
		});
	}
	
	@Test
	void list3() {
		List<BoardDto> list = br.list3();
		list.forEach(board->{
			System.out.println(board);
		});
	}
}
