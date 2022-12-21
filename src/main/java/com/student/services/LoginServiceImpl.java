package com.student.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dto.OwnerDto;
import com.student.entity.Login;
import com.student.entity.LoginStatus;
import com.student.entity.Admin;
import com.student.exception.InvalidIDException;
import com.student.repository.LoginRepo;


@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginRepo loginRepo;
	
	@Autowired
	private AdminService adminService;

	
	@Override
	public String login(OwnerDto OwnerDTO) {
		List<Login> loginList = loginRepo.findAll();
		if(loginList.size()>0) {
			for(Login log:loginList) {
				if(log.getStatus()==LoginStatus.LogedIn) {
					throw new InvalidIDException("Already Logged In", "Login", log.getLoginId());
				}
			}
		}
		Admin admin = adminService.findByEmailAndPassword(OwnerDTO.getEmail(), OwnerDTO.getPassword());
		if(admin !=null) {
			Login newLogin = new Login();
			newLogin.setApiKey(UUID.randomUUID().toString().replace("-", "-").substring(0, 10));
			newLogin.setStatus(LoginStatus.LogedIn);
			loginRepo.save(newLogin);
			return "YOU are successfully login";
		}else
		{
			throw new InvalidIDException("Insert Valid Email and Password", "OwnerId", OwnerDTO.getId());
		}
		
		
		
	}

	

	@Override
	public String logout() {
		List<Login> loginList = loginRepo.findAll();
		if(loginList.size()>0) {
			boolean flag = false;
			for(Login log: loginList) {
				if(log.getStatus()==LoginStatus.LogedIn) {
					flag = true;
					log.setStatus(LoginStatus.LogedOut);
				}
			}
			if(flag) {
				loginRepo.saveAll(loginList);
				return "Successfully Logout";
			}
			else
			{
				return "You have to login first...";
			}
		}
		
		return "You hvae to login first";
	}

	@Override
	public Admin loginDetail() throws Exception {
		List<Login> loginList = loginRepo.findAll();
		for(Login log: loginList) {
			if(log.getStatus()==LoginStatus.LogedIn) {
				return log.getOwner();
			}
		}
		throw new Exception("You have to login first!!!");
	}
	
	
}
