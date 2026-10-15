package com.almora.almora.Services;

import com.almora.almora.Model.Donacion;

import java.util.List;
import java.util.Optional;

public interface DonacionService {

    Donacion guardarDonacion(Donacion donacion);

    List<Donacion> listarDonaciones();

    Optional<Donacion> obtenerPorId(String id);

    void eliminarDonacion(String id);
}
