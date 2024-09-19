package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Myuser;

public interface MyuserRepository extends JpaRepository<Myuser, String>  {
	
	
}
