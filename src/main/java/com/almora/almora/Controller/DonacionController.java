package com.almora.almora.Controller;

import com.almora.almora.Model.Donacion;
import com.almora.almora.Services.DonacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/donaciones")
@CrossOrigin(origins = "*")
public class DonacionController {

    @Autowired
    private DonacionService donacionService;

    @PostMapping
    public Donacion guardar(@RequestBody Donacion donacion) {
        return donacionService.guardarDonacion(donacion);
    }

    @GetMapping
    public List<Donacion> listar() {
        return donacionService.listarDonaciones();
    }

    @GetMapping("/{id}")
    public Optional<Donacion> obtener(@PathVariable String id) {
        return donacionService.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        donacionService.eliminarDonacion(id);
    }
}