package com.devsu.hackerearth.backend.account.domain.model.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Base {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public Long getId(){
		return id;
	}
	public void setId(Long Identity){
		this.id = Identity;
	}
}
