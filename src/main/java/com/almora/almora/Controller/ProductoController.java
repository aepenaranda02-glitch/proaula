package com.almora.almora.Controller;

import com.almora.almora.Model.Producto;
import com.almora.almora.Services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    //  Agregar un producto
    @PostMapping
    public Producto agregarProducto(@RequestBody Producto producto) {
        return productoService.agregarProducto(producto);
    }

    //  Listar todos los productos
    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    //  Obtener producto por ID
    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable String id) { // Cambié Long → String
        return productoService.obtenerPorId(id);
    }

    //  Buscar producto por nombre
    @GetMapping("/nombre/{nombreProducto}")
    public Producto buscarPorNombre(@PathVariable String nombreProducto) {
        return productoService.buscarPorNombre(nombreProducto);
    }

    //  Actualizar producto completo (PUT por ID)
    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable String id, @RequestBody Producto producto) { 
        return productoService.actualizarProducto(id, producto);
    }

    //  Actualizar cantidad usando nombre
    @PutMapping("/cantidad/{nombreProducto}")
    public boolean actualizarCantidad(
            @PathVariable String nombreProducto,
            @RequestParam int nuevaCantidad) {
        return productoService.actualizarCantidad(nombreProducto, nuevaCantidad);
    }

    //  Eliminar producto por ID
    @DeleteMapping("/{id}")
    public boolean eliminarProducto(@PathVariable String id) { // Cambié Long → String
        return productoService.eliminarProducto(id);
    }
}
