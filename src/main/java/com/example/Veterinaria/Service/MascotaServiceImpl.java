package com.example.Veterinaria.Service;

import com.example.Veterinaria.Model.Mascota;
import com.example.Veterinaria.Repository.MascotaRepository;
import com.example.Veterinaria.DTO.MascotaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaServiceImpl implements MascotaService {

    private final MascotaRepository mascotaRepository;

    public MascotaServiceImpl(MascotaRepository mascotaRepository){
        this.mascotaRepository = mascotaRepository;
    }
//utilizamos el DTON para la logica del codigo
    private Mascota toEntity(MascotaDTO dto){
        Mascota mascota = new Mascota();
        mascota.setNombre(dto.getNombre());
        mascota.setEspecie(dto.getEspecie());
        mascota.setRaza(dto.getRaza());
        mascota.setEdad(dto.getEdad());
        mascota.setPeso(dto.getPeso());
        return mascota;
    }

    @Override
    public List<Mascota> listarTodas(){
        return mascotaRepository.findAll();
    }

    @Override
    public Mascota buscarPorCodigo(Long codigo) {
        return mascotaRepository.findById(codigo)
                .orElseThrow(() -> new RuntimeException("Mascota no encontrada con codigo: " + codigo));
    }

    @Override
    public Mascota guardar(MascotaDTO dto) {
        return mascotaRepository.save(toEntity(dto));
    }

    @Override
    public Mascota actualizar(Long codigo, MascotaDTO dto) {
        Mascota mascota = buscarPorCodigo(codigo);
        mascota.setNombre(dto.getNombre());
        mascota.setEspecie(dto.getEspecie());
        mascota.setRaza(dto.getRaza());
        mascota.setEdad(dto.getEdad());
        mascota.setPeso(dto.getPeso());
        return mascotaRepository.save(mascota);
    }

    @Override
    public void eliminar(Long codigo) {
        if (!mascotaRepository.existsById(codigo)) {
            throw new RuntimeException("Mascota no encontrada con codigo: " + codigo);
        }
        mascotaRepository.deleteById(codigo);
    }
}
