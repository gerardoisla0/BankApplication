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
@Table(name = "client")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Client extends Base {
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @Column(name = "person_id", nullable = false)
    private Long person_id;
    public Long getId() {
        return super.getId();
    }
    public Client(Long id){
        super.setId(id);
    }
}
