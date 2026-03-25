package com.example.Veterinaria.DTO;

import lombok.Data;

@Data
//variables visibles al publico NO ESTA EL CODIGO
public class MascotaDTO {

    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private double peso;
}
