package com.example.base.business.entities;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity extends AuditTable{

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "status")
    private Integer status;

}

