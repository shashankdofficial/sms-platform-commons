package com.student.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;
	
	@Column(name="Owner_Name",nullable = false,length=25)
	private String name;
	
	@Column(name="Email",nullable = false,length=20)
	private String email;
	
	@Column(name="Password", nullable = false, length=15)
	private String password;
}
