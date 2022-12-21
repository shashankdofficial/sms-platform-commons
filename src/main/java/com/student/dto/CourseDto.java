package com.student.dto;

import com.student.entity.Student;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CourseDto {
 
	
	private int course_id;
	
	@NotEmpty
	@Size(min= 4, message= "Course Name Must be min of 4 char!!!!")
	private String courseName;
	
	@NotEmpty
	@Size(min=10, max=50,message= "Description must be min of 10 char and max of 50 char!!!")
	private String description;
	
	@NotEmpty
	private String courseType;
	
	@NotEmpty
	private int duration;
	
	@NotEmpty
	private String courseTopics;
	
	
	private Student student;
}
