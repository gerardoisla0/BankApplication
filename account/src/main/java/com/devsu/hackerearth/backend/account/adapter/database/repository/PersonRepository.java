package com.devsu.hackerearth.backend.account.adapter.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsu.hackerearth.backend.account.domain.model.entity.Person;

@Repository
public interface PersonRepository  extends JpaRepository<Person, Long> {

}
