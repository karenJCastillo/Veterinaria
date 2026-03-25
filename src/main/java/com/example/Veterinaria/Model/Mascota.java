package com.example.Veterinaria.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data // atrae todos getters setters etc
@Table(name = "mascotas")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    @Column(nullable = false, length = 80)
    private String nombre;

    @Column(nullable = false, length = 60)
    private String especie;

    @Column(nullable = false, length = 60)
    private String raza;

    @Column(nullable = false)
    private int edad;

    @Column(nullable = false)
    private double peso;
}
