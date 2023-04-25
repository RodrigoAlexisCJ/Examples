package com.example.validationexample.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {
	private int userId;
	@NotNull(message = "name shouldn´t be null")
	private String name;
	@Email(message = "Invalid Email address")
	private String email;
	@Pattern(regexp = "^\\d{10}$", message = "Invalid Mobile number entered")
	private String mobile;
	private String gender;
	@Min(18)
	@Max(65)
	private int age;
	@NotBlank
	private String nationality;
	
	public UserRequest(String name, String email, String mobile, 
			String gender, int age, String nationality) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.age = age;
		this.nationality = nationality;
	}
	
}
