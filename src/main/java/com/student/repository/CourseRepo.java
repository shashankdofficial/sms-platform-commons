package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.entity.Course;

public interface CourseRepo  extends JpaRepository<Course, Integer>{

}
