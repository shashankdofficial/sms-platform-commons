package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.entity.Login;

public interface LoginRepo extends JpaRepository<Login, Integer>{

}
