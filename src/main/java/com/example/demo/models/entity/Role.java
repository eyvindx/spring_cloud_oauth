package com.example.demo.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="roles")
public class Role implements Serializable {

    private static final long serialVersionUID = 6068032971111275191L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id ;
    private String nombre ;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

