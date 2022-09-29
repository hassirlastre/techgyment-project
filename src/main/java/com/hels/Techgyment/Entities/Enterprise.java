package com.hels.Techgyment.Entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data //Crea los getters and setters de cada uno de los atributos; también un constructor vacío.
@Entity
@Table(name = "enterprises")
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "nit")
    private String nit;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    public Enterprise() {

    }

    public Enterprise(Long id, String name, String nit, String phone, String address, Timestamp createAt, Timestamp updateAteAt) {
        this.id = id;
        this.name = name;
        this.nit = nit;
        this.phone = phone;
        this.address = address;
        this.createdAt = createAt;
        this.updatedAt = updateAteAt;
    }
}
