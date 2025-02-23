package com.devsu.hackerearth.backend.client.domain.usecase;

import java.util.List;

import com.devsu.hackerearth.backend.client.adapter.controller.model.inbound.ClientRequestDto;
import com.devsu.hackerearth.backend.client.adapter.controller.model.inbound.PartialClientRequestDto;
import com.devsu.hackerearth.backend.client.adapter.controller.model.outbound.ClientResponseDto;

public interface ClientUseCase {
    public List<ClientResponseDto> getAll();
	public ClientResponseDto getById(Long id);
	public ClientResponseDto create(ClientRequestDto clientDto);
	public ClientResponseDto update(Long id, ClientRequestDto clientDto);
	public ClientResponseDto partialUpdate(Long id, PartialClientRequestDto clientDto);
	public void deleteById(Long id);
}
