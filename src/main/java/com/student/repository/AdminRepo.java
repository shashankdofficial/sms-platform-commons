package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.entity.Admin;


public interface AdminRepo extends JpaRepository<Admin, Integer>{

}
