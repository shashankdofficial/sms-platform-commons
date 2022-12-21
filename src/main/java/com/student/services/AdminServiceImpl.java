package com.student.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.student.dto.CourseDto;
import com.student.dto.OwnerDto;
import com.student.dto.StudentDto;
import com.student.entity.Course;
import com.student.entity.Admin;
import com.student.entity.Student;
import com.student.exception.ResourseNotFoundException;
import com.student.repository.CourseRepo;
import com.student.repository.AdminRepo;
import com.student.repository.StudentRepo;

public class AdminServiceImpl implements AdminService{

	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//Student
	public Student dtoToStudent(StudentDto studentDto) {
		Student student = this.modelMapper.map(studentDto, Student.class);
		return student;
	}
	
	//
	public StudentDto studentToDto(Student student) {
		StudentDto studentDto = this.modelMapper.map(student, StudentDto.class);
		return studentDto;
	}
	
	//Course
	public Course dtoToCourse(CourseDto courseDto) {
		Course course = this.modelMapper.map(courseDto, Course.class);
		return course;
	}
	
	// 
	public CourseDto coursetoDto(Course course) {
		CourseDto coursedto = this.modelMapper.map(course, CourseDto.class);
		return coursedto;
	}
	
	
	
	@Override
	public StudentDto admitStudents(StudentDto studentDto) {
		Student student = this.dtoToStudent(studentDto);
		Student savedStudent = this.studentRepo.save(student);
		return this.studentToDto(savedStudent);
	}

	@Override
	public CourseDto createCourse(CourseDto courseDto) {
		Course course = this.dtoToCourse(courseDto);
		Course savedCourse = this.courseRepo.save(course);		
		return this.coursetoDto(savedCourse);
	}

	@Override
	public StudentDto getStudents(String name) {
		List<Student> list = this.studentRepo.findAll();
		for(Student stu: list) {
			if(stu.getName().equals(name)) {
				return this.studentToDto(stu);
			}
		}
		return null;
	}

	@Override
	public void deleteStudent(Integer student_id) {
		Student student = this.studentRepo.findById(student_id).orElseThrow(()-> new ResourseNotFoundException("Student", "Id",student_id));
		this.studentRepo.delete(student);;
	}

	@Override
	public CourseDto addCourse(Integer student_id, CourseDto courseDto) {
		Optional<Student> opt = studentRepo.findById(student_id);
		if(opt.isPresent()) {
			opt.get().getCourse().add(this.dtoToCourse(courseDto));
			studentRepo.save(opt.get());
			return courseDto;
		}
		return null;
	}

	@Override
	public List<StudentDto> getAllStudentByCourse(Integer courseId) {
		List<Student> list = this.studentRepo.findAll();
		List<Student> list1 = new ArrayList<>();
		for(Student std:list) {
			
			List<Course> course = std.getCourse();
			for(Course cour:course) {
				if(cour.getCourse_id()==courseId) {
					list1.add(std);
				}
			}
			
		}
		return list1.stream().map(student->this.studentToDto(student)).collect(Collectors.toList());
	}

	@Override
	public Admin findByEmailAndPassword(String userEmial, String password) {
		List<Admin> owner_list= adminRepo.findAll();
		for(Admin own:owner_list) {
			if(own.getEmail().equals(userEmial) && own.getPassword().equals(password)) {
				return own;
			}
		}
		return null;
	}
   
}
