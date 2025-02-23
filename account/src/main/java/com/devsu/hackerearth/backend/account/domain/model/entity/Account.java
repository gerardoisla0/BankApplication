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
@Table(name = "account")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Account extends Base {
    
    @Column(name = "number", nullable = false)
    private String number;
    @Column(name = "type", nullable = false)
	private String type;
    @Column(name = "initialAmount", nullable = false)
	private double initialAmount;
    @Column(name = "active", nullable = false)
	private boolean active;
    @Column(name = "client_id", nullable = false)
    private Long clientId;

    public Long getId(){
        return super.getId();
    }
    public Account(Long id){
        super.setId(id);
    }
}
