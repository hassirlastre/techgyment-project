package com.hels.Techgyment.Entities;

import lombok.Data;

import javax.persistence.*;

@Data //Crea los getters and setters de cada uno de los atributos; también un constructor vacío.
@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public Profile() {

    }

    public Profile(String Long, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
