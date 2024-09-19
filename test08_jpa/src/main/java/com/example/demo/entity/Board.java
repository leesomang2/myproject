package com.example.demo.entity;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * FetchType : JPA가 하나의 Entity를 조회할때 연관관계에 있는 객체들을 어떻게 가져올 것이냐를 나타내는 설정값.
 * @xxToxx(fetch = fecthType.EAGER) : 즉시로딩 ==> 데이터를 조회할 때, 연관된 모든 객체의 데이터까지 한 번에 불러옴
 * @xxToxx(fetch = fecthType.LAZY) : 지연로딩 ==> 필요한 시점에 연관된 객체의 데이터를 불러옴
 * */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //자동으로 값넣기
	private Long num;
	
	@ManyToOne(fetch = FetchType.LAZY) // 다 대 1 관계
	@JoinColumn(name="username")
	private Myuser user;
	private String title;
	@Lob
	private String content;
	@CreationTimestamp
	private Date regdate;
}
