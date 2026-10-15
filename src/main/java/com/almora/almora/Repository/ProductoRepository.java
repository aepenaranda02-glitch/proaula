package com.almora.almora.Repository;

import com.almora.almora.Model.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoRepository extends MongoRepository<Producto, String> {
     Producto findByNombreProducto(String nombreProducto);

     Producto findByNombreProductoIgnoreCase(String nombreProducto);
}
