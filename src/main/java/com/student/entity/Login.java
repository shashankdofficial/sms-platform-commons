package com.student.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Login {

	private int loginId;
	
	private String apiKey;
	
	private LoginStatus status;
	
	@JsonIgnoreProperties("login")
	@OneToOne(cascade = CascadeType.ALL)
	private Admin admin;
}
