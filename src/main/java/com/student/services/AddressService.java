package com.student.services;

import java.util.List;

import com.student.dto.AddressDto;
import com.student.dto.StudentDto;

public interface AddressService {

	    public List<AddressDto> viewAddress(Integer id);
	    public AddressDto addAddress(Integer student_id,AddressDto address);
	    public AddressDto updateAddress(AddressDto addressDto , Integer student_id);
	
}
