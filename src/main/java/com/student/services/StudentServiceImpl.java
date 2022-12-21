package com.student.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dto.CourseDto;
import com.student.dto.StudentDto;
import com.student.entity.Course;
import com.student.entity.Student;
import com.student.exception.ResourseNotFoundException;
import com.student.repository.CourseRepo;
import com.student.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepo studentRepo; 
	
	@Autowired
	private CourseRepo courseRepo;
	
	
	@Autowired
	private ModelMapper moddleMapper;

	//to change the studentDto to the student; 
	public Student dtoToStudent(StudentDto dto) {
		Student student = this.moddleMapper.map(dto, Student.class);
		return student;
	}
	
	//to change the student to the studentDto; 
    public StudentDto studentToDto(Student student) {	
    	StudentDto dto = this.moddleMapper.map(student, StudentDto.class);
    	return dto;
    }
	
  //to change the CourseDto to the course; 
  	public Course dtoToCourse(CourseDto dto) {
  		Course course = this.moddleMapper.map(dto, Course.class);
  		return course;
  	}
  	
  	//to change the course to the courseDto; 
      public CourseDto courseToDto(Course course) {	
      CourseDto dto = this.moddleMapper.map(course, CourseDto.class);
      	return dto;
      }
	

	@Override
	public List<CourseDto> getAllCourses() {
		List<Course> list = this.courseRepo.findAll();
		List<CourseDto> dto =  list.stream().map(student->this.courseToDto(student)).collect(Collectors.toList());
		return dto;
	}

	@Override
	public void leaveCourse(Integer course_id) {
		Course course = this.courseRepo.findById(course_id).orElseThrow(()-> new ResourseNotFoundException("Student", "Course", course_id));
		this.courseRepo.delete(course);
	}

	@Override
	public StudentDto updateStudent(StudentDto studentDto, Integer student_id) {
		
		Student student =this.studentRepo.findById(student_id).orElseThrow(()-> new ResourseNotFoundException("Student", "Student_id", student_id));
		student.setEmail(studentDto.getEmail());
		student.setParentsName(studentDto.getParentsName());
		student.setMobileNumber(studentDto.getMobileNumber());
		
		Student updatedStudent = this.studentRepo.save(student);
		return this.studentToDto(updatedStudent);
	}
	
	
	
}
