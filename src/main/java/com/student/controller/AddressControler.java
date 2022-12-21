package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.dto.AddressDto;
import com.student.dto.CourseDto;
import com.student.dto.StudentDto;
import com.student.entity.Address;
import com.student.exception.NullValueExcception;
import com.student.services.AddressService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/address")
public class AddressControler {

	@Autowired
	private AddressService addressService;
	
	//get - getAllCourse
		@GetMapping("/")
		public ResponseEntity<List<AddressDto>> viewAddress(@Valid @PathVariable Integer student_id){
			return ResponseEntity.ok(this.addressService.viewAddress(student_id));
		}
	
	// post - adding the course 
		@PostMapping("/{student_id}")
		public ResponseEntity<String> addCourse(@PathVariable Integer student_id,@RequestBody AddressDto addressDto){
			AddressDto address = addressService.addAddress( student_id,addressDto);
			if(address==null) {
				throw new NullValueExcception("Value Not Found", "Student_Id", student_id);
			}
			else
			{
				return new ResponseEntity<String>("Address Added"+address,HttpStatus.ACCEPTED);
			}
		}
		//put - update
		@PutMapping("/{student_id}")
		public ResponseEntity<AddressDto> updateAddressDetails(@Valid @RequestBody AddressDto addressDto,@PathVariable Integer student_iD){
			AddressDto updatedAddress = this.addressService.updateAddress(addressDto, student_iD);
			return ResponseEntity.ok(updatedAddress);
		}
}
