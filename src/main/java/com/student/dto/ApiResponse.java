package com.student.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ApiResponse  {

	public ApiResponse(String message2, boolean b) {
		
	}
	private String message;
	private boolean success;
}
