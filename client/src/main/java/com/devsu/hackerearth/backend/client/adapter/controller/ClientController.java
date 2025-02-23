package com.devsu.hackerearth.backend.client.adapter.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsu.hackerearth.backend.client.adapter.controller.model.inbound.ClientRequestDto;
import com.devsu.hackerearth.backend.client.adapter.controller.model.inbound.PartialClientRequestDto;
import com.devsu.hackerearth.backend.client.adapter.controller.model.outbound.ClientResponseDto;
import com.devsu.hackerearth.backend.client.config.enums.MessageResponse;
import com.devsu.hackerearth.backend.client.config.response.ApiResponse;
import com.devsu.hackerearth.backend.client.domain.usecase.ClientUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

	private final ClientUseCase clientUseCase;

	@GetMapping
	public ResponseEntity<ApiResponse<List<ClientResponseDto>>> getAll() {
		List<ClientResponseDto> listClient = clientUseCase.getAll();
		ApiResponse<List<ClientResponseDto>> response = new ApiResponse<>(listClient, MessageResponse.SUCCESS);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<ClientResponseDto>> get(@PathVariable Long id) {
		ClientResponseDto client = clientUseCase.getById(id);
		ApiResponse<ClientResponseDto> response = new ApiResponse<>(client, MessageResponse.SUCCESS);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PostMapping
	public ResponseEntity<ApiResponse<ClientResponseDto>> create(@Valid @RequestBody ClientRequestDto clientDto) {
		ClientResponseDto client = clientUseCase.create(clientDto);
		ApiResponse<ClientResponseDto> response = new ApiResponse<>(client, MessageResponse.SUCCESS);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<ClientResponseDto>> update(@PathVariable Long id, @Valid @RequestBody ClientRequestDto clientDto) {
		ClientResponseDto client = clientUseCase.update(id, clientDto);
		ApiResponse<ClientResponseDto> response = new ApiResponse<>(client, MessageResponse.SUCCESS);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<ApiResponse<ClientResponseDto>> partialUpdate(@PathVariable Long id, @Valid @RequestBody PartialClientRequestDto clientDto) {
		ClientResponseDto client = clientUseCase.partialUpdate(id, clientDto);
		ApiResponse<ClientResponseDto> response = new ApiResponse<>(client, MessageResponse.SUCCESS);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		clientUseCase.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
}
