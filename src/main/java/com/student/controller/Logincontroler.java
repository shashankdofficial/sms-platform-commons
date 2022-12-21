package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.dto.OwnerDto;
import com.student.exception.InvalidIDException;
import com.student.services.LoginService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Admin")
public class Logincontroler {

	@Autowired
	private LoginService loginservice;
	
	@PostMapping("/login/{type}")
	public ResponseEntity<String> loginUser(@RequestBody @Valid OwnerDto loginInfo, @PathVariable String type) {
		if(type.equalsIgnoreCase("Customer") || type.equalsIgnoreCase("Admin")){
			String s = loginservice.login(loginInfo);
			return new ResponseEntity<String>(s,HttpStatus.OK);
		}
		else {
			throw new InvalidIDException("Invalid Uri","Login",loginInfo.getId());
		}
	}
	
	
	@GetMapping("/logout")
	public String logoutUser() {
		return loginservice.logout();
	}
}
