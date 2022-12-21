package com.student.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="Student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int student_id;
	
	@Column(name="Student_Name" , nullable = false, length = 100)
	private String name;
	
	@Column(name = "Dob" , nullable = false, length=100)
	private Date dateOfBirth;
	
	@Column(name = "Gender", nullable = false , length=10)
	private String gender;
	
	@Column(name = "Student_Email", nullable = false , length=100)
	private String email;
	
	@Column(name = "Student_Password", nullable = false, length=15)
	private String password;
	
	@Column(name = "Student_Mobile_Number" , nullable = false, length=10)
	private String mobileNumber;
	
	@Column(name ="Parents_Name", nullable = false, length=100)
	private String parentsName;
	
	
	@JoinColumn(name = "id",referencedColumnName = "address_id")
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Address> address = new ArrayList<>();
	
	@JoinColumn(name = "id",referencedColumnName = "course_id")
	@ManyToMany( cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Course> course = new ArrayList<>();
	
}
