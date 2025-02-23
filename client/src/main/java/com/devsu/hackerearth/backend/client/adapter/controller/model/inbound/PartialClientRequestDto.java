package com.devsu.hackerearth.backend.client.adapter.controller.model.inbound;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class PartialClientRequestDto {

	@Size(min = 8, max = 8, message = "El DNI debe teber exactamente 8 caracteres")
	private String dni;

	private String name;

	private String password;

	private String gender;

	private Integer age;

	private String address;

	private String phone;

}
