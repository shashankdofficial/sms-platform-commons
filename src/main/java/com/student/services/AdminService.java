package com.student.services;

import java.util.List;

import com.student.dto.CourseDto;
import com.student.dto.StudentDto;
import com.student.entity.Admin;

public interface AdminService {

	StudentDto admitStudents(StudentDto studentDto);
	CourseDto  createCourse(CourseDto courseDto);
	StudentDto getStudents(String name);
	void deleteStudent(Integer student_id);
	CourseDto addCourse(Integer student_id,CourseDto courseDto);
	List<StudentDto> getAllStudentByCourse(Integer courseId);
	public Admin findByEmailAndPassword(String userEmial, String password);

} 
