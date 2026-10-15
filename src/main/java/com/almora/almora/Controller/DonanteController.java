package com.almora.almora.Controller;

import com.almora.almora.Model.Donante;
import com.almora.almora.Services.DonanteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/donantes")
@CrossOrigin(origins = "*")
public class DonanteController {

    @Autowired
    private DonanteService donanteService;

    @PostMapping
    public Donante saveDonante(@RequestBody Donante donante) {
        return donanteService.saveDonante(donante);
    }

    @GetMapping
    public List<Donante> getAllDonantes() {
        return donanteService.getAllDonantes();
    }

    @GetMapping("/{id}")
    public Optional<Donante> getDonanteById(@PathVariable String id) {
        return donanteService.getDonanteById(id);
    }

    @PutMapping("/{id}")
    public Donante updateDonante(@PathVariable String id, @RequestBody Donante donante) {
        return donanteService.updateDonante(id, donante);
    }

    @DeleteMapping("/{id}")
    public void deleteDonante(@PathVariable String id) {
        donanteService.deleteDonante(id);
    }
}