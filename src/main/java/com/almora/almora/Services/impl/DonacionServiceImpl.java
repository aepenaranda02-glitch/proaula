package com.almora.almora.Services.impl;

import com.almora.almora.Model.Donacion;
import com.almora.almora.Model.Producto; // Importación obligatoria
import com.almora.almora.Repository.DonacionRepository;
import com.almora.almora.Repository.ProductoRepository; // Importación obligatoria para el cruce de datos
import com.almora.almora.Services.DonacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonacionServiceImpl implements DonacionService {

    @Autowired
    private DonacionRepository donacionRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Donacion guardarDonacion(Donacion donacion) {
        // 1. Guardar el registro de la donación
        Donacion donacionGuardada = donacionRepository.save(donacion);

        if (donacion.getProductos() != null && !donacion.getProductos().isEmpty()) {
            // 2. Extraemos el ID del producto (que ahora viene del frontend)
            String idProducto = donacion.getProductos().get(0).toString();
            int cantidadDonada = donacion.getCantidad();

            // 3. BUSCAMOS POR ID (Mucho más seguro que por nombre)
            Producto productoExistente = productoRepository.findById(idProducto).orElse(null);

            if (productoExistente != null) {
                // 4. Sumamos al stock existente
                int nuevoStock = productoExistente.getCantidad() + cantidadDonada;
                productoExistente.setCantidad(nuevoStock);

                // 5. Actualizamos el producto en la base de datos
                productoRepository.save(productoExistente);
            }
        }
        return donacionGuardada;
    }

    @Override
    public List<Donacion> listarDonaciones() {
        return donacionRepository.findAll();
    }

    @Override
    public Optional<Donacion> obtenerPorId(String id) {
        return donacionRepository.findById(id);
    }

    @Override
    public void eliminarDonacion(String id) {
        Optional<Donacion> donacionOpt = donacionRepository.findById(id);

        if (donacionOpt.isPresent()) {
            Donacion donacion = donacionOpt.get();

            if (donacion.getProductos() != null && !donacion.getProductos().isEmpty()) {
                String idProducto = donacion.getProductos().get(0).toString();
                int cantidadRestar = donacion.getCantidad();

                Producto productoExistente = productoRepository.findById(idProducto).orElse(null);

                if (productoExistente != null) {
                    int nuevoStock = productoExistente.getCantidad() - cantidadRestar;

                    // Seguridad: No permitir stock negativo
                    productoExistente.setCantidad(Math.max(0, nuevoStock));
                    productoRepository.save(productoExistente);
                }
            }
            // Finalmente eliminamos el registro de la donación
            donacionRepository.deleteById(id);
        }
    }
}
