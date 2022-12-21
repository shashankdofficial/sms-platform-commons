package com.student.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.dto.ApiResponse;
import com.student.dto.CourseDto;
import com.student.dto.StudentDto;
import com.student.services.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/student")
public class StudnetControler {

	@Autowired
	private StudentService studentService;
	
	
	//put - update
	@PutMapping("/{studentId}")
	public ResponseEntity<StudentDto> updateStudentDetails(@Valid @RequestBody StudentDto studentDto,@PathVariable Integer student_iD){
		StudentDto updatedStudent = this.studentService.updateStudent(studentDto, student_iD);
		return ResponseEntity.ok(updatedStudent);
	}
	
	//get - getAllCourse
	@GetMapping("/")
	public ResponseEntity<List<CourseDto>> getAllCourses(){
		return ResponseEntity.ok(this.studentService.getAllCourses());
	}
	
	//delete- leaveCourse
	@DeleteMapping("/{course_id}")
	public ResponseEntity<ApiResponse> leaveCourse(@PathVariable Integer course_id){
		this.studentService.leaveCourse(course_id);
		return new ResponseEntity<ApiResponse> ( new ApiResponse("Leave Course Successfully!!", true),HttpStatus.OK);
	}
	
}











