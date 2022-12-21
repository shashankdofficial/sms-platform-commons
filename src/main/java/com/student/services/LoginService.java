package com.student.services;

import org.springframework.stereotype.Service;

import com.student.dto.OwnerDto;
import com.student.entity.Admin;

@Service
public interface LoginService {

    public String login(OwnerDto OwnerDTO);
	
	
	
	public String logout() ;
	
	public Admin loginDetail() throws Exception;
	
}
