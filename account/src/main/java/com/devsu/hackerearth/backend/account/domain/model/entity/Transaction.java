package com.devsu.hackerearth.backend.account.domain.model.entity;

import java.time.LocalDateTime;

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
@Table(name = "transactions")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Transaction extends Base {

	@Column(name = "date", nullable = false)
	private LocalDateTime date;
	@Column(name = "type", nullable = false)
	private String type;
	@Column(name = "amount", nullable = false)
	private double amount;
	@Column(name = "balance", nullable = false)
	private double balance;
	@Column(name = "account_id", nullable = false)
	private Long accountId;

	public Long getId() {
		return super.getId();
	}
}
