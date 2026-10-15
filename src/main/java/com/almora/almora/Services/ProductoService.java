package com.almora.almora.Services;

import com.almora.almora.Model.Producto;
import java.util.List;

public interface ProductoService {

    Producto agregarProducto(Producto producto);

    List<Producto> listarProductos();

    Producto buscarPorNombre(String nombreProducto);

    boolean actualizarCantidad(String nombreProducto, int nuevaCantidad);

    boolean eliminarProducto(String id);

    Producto obtenerPorId(String id);

    Producto actualizarProducto(String id, Producto productoActualizado);
}
