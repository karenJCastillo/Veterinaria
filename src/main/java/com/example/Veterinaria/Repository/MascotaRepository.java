package com.example.Veterinaria.Repository;

import com.example.Veterinaria.Model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
//se define mascota como long (codigo)
public interface MascotaRepository extends JpaRepository<Mascota, Long> {

}