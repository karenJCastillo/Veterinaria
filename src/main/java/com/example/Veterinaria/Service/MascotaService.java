package com.example.Veterinaria.Service;

import com.example.Veterinaria.DTO.MascotaDTO;
import com.example.Veterinaria.Model.Mascota;

import java.util.List;
//metodods crud
public interface MascotaService {
    List<Mascota> listarTodas();
    Mascota buscarPorCodigo(Long codigo);
    Mascota guardar(MascotaDTO dto);
    Mascota actualizar(Long codigo, MascotaDTO dto);
    void eliminar(Long codigo);
}
