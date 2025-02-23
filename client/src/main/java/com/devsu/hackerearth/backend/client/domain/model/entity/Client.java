package com.devsu.hackerearth.backend.client.domain.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
public class Client extends Base{
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval =  true)
    @JoinColumn(name = "person_id")
    private Person person;
    public Long getId(){
        return super.getId();
    }
}
