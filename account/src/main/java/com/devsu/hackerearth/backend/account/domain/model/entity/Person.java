package com.devsu.hackerearth.backend.account.domain.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "person")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Person extends Base{
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "dni", unique = true, nullable = false)
	private String dni;
    @Column(name = "gender")
	private String gender;
    @Column(name = "age")
	private int age;
    @Column(name = "address")
	private String address;
    @Column(name = "phone")
	private String phone;
}