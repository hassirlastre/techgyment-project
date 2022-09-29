package com.hels.Techgyment.Entities;

import lombok.Data;

import javax.persistence.*;

@Data //Crea los getters and setters de cada uno de los atributos; también un constructor vacío.
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;

    @Column(name = "enterprise")
    private String enterprise;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public Employee() {

    }

    public Employee(Long id, String name, String email, String role, String enterprise, String username, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.enterprise = enterprise;
        this.username = username;
        this.password = password;
    }
}
