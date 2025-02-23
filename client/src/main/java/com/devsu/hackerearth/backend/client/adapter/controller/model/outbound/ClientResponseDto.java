package com.devsu.hackerearth.backend.client.adapter.controller.model.outbound;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDto {

	private Long id;
	private String dni;
	private String name;
	private String gender;
	private int age;
	private String address;
	private String phone;
	private boolean isActive;

}