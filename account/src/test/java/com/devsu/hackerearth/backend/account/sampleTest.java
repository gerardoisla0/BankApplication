package com.devsu.hackerearth.backend.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import com.devsu.hackerearth.backend.account.adapter.controller.model.outbound.AccountResponseDto;
import com.devsu.hackerearth.backend.account.config.response.ApiResponse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
public class sampleTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void shouldReturnAccountsById() throws Exception {

		ResponseEntity<ApiResponse<AccountResponseDto>> response = 
		testRestTemplate.exchange("/api/accounts/1", HttpMethod.GET, null, new ParameterizedTypeReference<ApiResponse<AccountResponseDto>>() {});

		System.out.println("Raw Response: " + response.getBody());

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals(200, response.getBody().getStatusCode());
	}

	@Test
	public void shouldReturnAllAccounts() throws Exception {

		ResponseEntity<ApiResponse<List<AccountResponseDto>>> response = 
		testRestTemplate.exchange("/api/accounts/", HttpMethod.GET, null, new ParameterizedTypeReference<ApiResponse<List<AccountResponseDto>>>() {});

		System.out.println("Raw Response: " + response.getBody());

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals(200, response.getBody().getStatusCode());
	}

}
