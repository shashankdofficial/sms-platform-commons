package com.student.services;

import java.util.List;

import com.student.dto.CourseDto;
import com.student.dto.StudentDto;

public interface StudentService {

	
	StudentDto updateStudent(StudentDto studentDto , Integer student_id);
	List<CourseDto> getAllCourses();
	void leaveCourse(Integer id);
	
}
