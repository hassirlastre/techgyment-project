package com.hels.Techgyment.Entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}
