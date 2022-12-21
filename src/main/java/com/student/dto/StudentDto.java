package com.student.dto;

import java.util.Date;

import com.student.entity.Address;
import com.student.entity.Course;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StudentDto {

	private int student_id;
	
	@NotEmpty
	@Size(min=4 ,message= "Name must be min of 4 character!!!")
	private String name;
	
	@NotEmpty
	@Pattern(regexp="(0/91)?[6-9][0-9]{9}", message = "MobileNumber must be 10 Intergers.")
	private String mobileNumber;
	
	
	@Email(message = "Please Enter Valid Email")
	private String email;
	
	@NotEmpty
	@Pattern(regexp="[a-zA-Z0-9]{6,12}",message="Password must contain between 6 to 12 characters. Must be alphanumeric with both Upper and lowercase characters.")
	private String password;
	
	@NotEmpty
	private Date dateOfBirth;
	
	@NotEmpty
	private String gender;
	
	@NotEmpty
    private String parentsName;
	
	private Course course;
	
	private Address address;
}
