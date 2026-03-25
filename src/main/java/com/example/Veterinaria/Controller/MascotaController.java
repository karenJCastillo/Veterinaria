package com.example.Veterinaria.Controller;

import com.example.Veterinaria.DTO.MascotaDTO;
import com.example.Veterinaria.Model.Mascota;
import com.example.Veterinaria.Service.MascotaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    private final MascotaService mascotaService;

    public MascotaController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    // GET /api/mascotas
    @GetMapping
    public ResponseEntity<List<Mascota>> listar() {
        return ResponseEntity.ok(mascotaService.listarTodas());
    }

    // GET /api/mascotas/{codigo}
    @GetMapping("/{codigo}")
    public ResponseEntity<Mascota> buscar(@PathVariable Long codigo) {
        try {
            return ResponseEntity.ok(mascotaService.buscarPorCodigo(codigo));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // POST /api/mascotas
    @PostMapping
    public ResponseEntity<Mascota> crear(@RequestBody MascotaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mascotaService.guardar(dto));
    }

    // PUT /api/mascotas/{codigo}
    @PutMapping("/{codigo}")
    public ResponseEntity<Mascota> actualizar(@PathVariable Long codigo, @RequestBody MascotaDTO dto) {
        try {
            return ResponseEntity.ok(mascotaService.actualizar(codigo, dto));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /api/mascotas/{codigo}
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> eliminar(@PathVariable Long codigo) {
        try {
            mascotaService.eliminar(codigo);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}