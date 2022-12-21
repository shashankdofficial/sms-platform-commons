package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.dto.ApiResponse;
import com.student.dto.CourseDto;
import com.student.dto.StudentDto;
import com.student.exception.NullValueExcception;
import com.student.services.AdminService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/owner")
public class AdminControler {

	@Autowired
	private AdminService adminService;
	
	
	//post - admit Student
	@PostMapping("/student/")
	public ResponseEntity<StudentDto> admitStudent(@Valid @RequestBody StudentDto studentDto){
		StudentDto admitStudent = this.adminService.admitStudents(studentDto);
		return new ResponseEntity<StudentDto>(admitStudent,HttpStatus.CREATED);
	}
	
	//post - Create Curse
	@PostMapping("/course/")
	public ResponseEntity<CourseDto> createCourse(@Valid @RequestBody CourseDto courseDto){
		CourseDto createCourse = this.adminService.createCourse(courseDto);
		return new ResponseEntity<CourseDto>(createCourse,HttpStatus.CREATED);
	}
	
	//get - getStudentByCourseId
	@GetMapping("/{courseId}")
	public ResponseEntity<List<StudentDto>> getStudentByCourse(@Valid @PathVariable Integer courseId){
		return ResponseEntity.ok(this.adminService.getAllStudentByCourse(courseId));
	}
	
	//get - get Student By Name
	@GetMapping("/{name}")
	public ResponseEntity<StudentDto> getStudentByName(@Valid @PathVariable String name){
		return ResponseEntity.ok(this.adminService.getStudents(name));
	}
	
	//delete - Delete Student
	@DeleteMapping("/{student_Id}")
	public ResponseEntity<ApiResponse> deleteStudent(@PathVariable Integer Student_Id){
		this.adminService.deleteStudent(Student_Id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Student Deleted Successfuliy!!", true),HttpStatus.OK);
	}
	
	// post - adding the course 
	@PostMapping("/{student_id}")
	public ResponseEntity<String> addCourse(@PathVariable Integer student_id,@RequestBody CourseDto courseDto){
		CourseDto owner = adminService.addCourse(student_id, courseDto);
		if(owner==null) {
			throw new NullValueExcception("Value Not Found", "Student_Id", student_id);
		}
		else
		{
			return new ResponseEntity<String>("Course Added"+owner,HttpStatus.ACCEPTED);
		}
	}
	
	
	
}
