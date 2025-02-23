package com.devsu.hackerearth.backend.client.adapter.controller.model.inbound;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDto {

	@NotNull(message = "DNI is required")
	@Size(min = 8, max = 8, message = "DNI must be exactly 8 characters long")
	private String dni;

	@NotNull(message = "Name is required")
	private String name;

	@NotNull(message = "Password is required")
	private String password;

	@NotNull(message = "Gender is required")
	private String gender;

	@NotNull(message = "Age is required")
	private Integer age;

	@NotNull(message = "Address is required")
	private String address;

	@NotNull(message = "Phone number is required")
	private String phone;

}
