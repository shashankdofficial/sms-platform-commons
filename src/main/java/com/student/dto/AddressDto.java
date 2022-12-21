package com.student.dto;
import com.student.entity.Student;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AddressDto {

	
	private int address_id;
	@NotEmpty
	private String area;
	
	@NotEmpty
	private String state;
	
	@NotEmpty
	private String distrct;
	
	@NotEmpty
	private String pincode;
	
	@NotEmpty
	private String addressType;
	
	
	private Student student;
}
