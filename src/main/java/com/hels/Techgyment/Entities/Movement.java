package com.hels.Techgyment.Entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data //Crea los getters and setters de cada uno de los atributos; también un constructor vacío.
@Entity
@Table(name = "movements")
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "concept")
    private String concept;

    @Column(name = "amount")
    private double amount;

    @Column(name = "employee")
    private String employee;

    @Column(name = "enterprise")
    private String enterprise;

    @Column(name = "created_at")
    private Date created_at;

    @Column(name = "updated_at")
    private Date updated_at;

    public Movement() {

    }

    public Movement(Long id, String concept, double amount, String employee, String enterprise, Date created_at, Date updated_at) {
        this.id = id;
        this.concept = concept;
        this.amount = amount;
        this.employee = employee;
        this.enterprise = enterprise;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
