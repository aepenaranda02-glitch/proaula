package com.almora.almora.Services.impl;

import com.almora.almora.Model.Donante;
import com.almora.almora.Model.Usuario;
import com.almora.almora.Repository.DonanteRepository;
import com.almora.almora.Repository.UsuarioRepository;
import com.almora.almora.Services.DonanteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonanteServiceImpl implements DonanteService {

    @Autowired
    private DonanteRepository donanteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Donante saveDonante(Donante donante) {

        // encriptar contraseña
        donante.setPassword(passwordEncoder.encode(donante.getPassword()));

        // asignar rol automáticamente
        donante.setRol("DONANTE");

        // guardar en donantes
        Donante guardado = donanteRepository.save(donante);

        // guardar también en usuarios (para login)
        Usuario usuario = new Usuario();
        usuario.setNombre(donante.getNombre());
        usuario.setCorreo(donante.getCorreo());
        usuario.setPassword(donante.getPassword());
        usuario.setRol("DONANTE");

        usuarioRepository.save(usuario);

        return guardado;
    }

    @Override
    public List<Donante> getAllDonantes() {
        return donanteRepository.findAll();
    }

    @Override
    public Optional<Donante> getDonanteById(String id) {
        return donanteRepository.findById(id);
    }

    @Override
    public Donante updateDonante(String id, Donante updated) {
        return donanteRepository.findById(id).map(donante -> {
            donante.setNombre(updated.getNombre());
            donante.setCorreo(updated.getCorreo());
            donante.setPassword(passwordEncoder.encode(updated.getPassword()));
            donante.setTelefono(updated.getTelefono());
            return donanteRepository.save(donante);
        }).orElseThrow(() -> new RuntimeException("Donante no encontrado"));
    }

    @Override
    public void deleteDonante(String id) {
        donanteRepository.deleteById(id);
    }
}