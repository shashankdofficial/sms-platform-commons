package com.student.entity;




import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Student_Course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Course_id",nullable = false, length=100)
	private int course_id;
	
	@Column(name= "Course_Name", nullable = false, length=50)
	private String courseName;
	
	@Column(name = "Course_Description", nullable = false, length=150)
	private String description;
	
	@Column(name = "Course_Type", nullable = false , length=50)
	private String courseType;
	
	@Column(name= "Course_Duration", nullable = false, length=50)
	private int duration;
	
	@Column(name ="Course_Topics", nullable = false, length=50)
	private String courseTopics;
	
	@ManyToMany(mappedBy = "course", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Student student ;
}
