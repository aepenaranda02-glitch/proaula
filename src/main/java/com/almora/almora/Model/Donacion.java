package com.almora.almora.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "donaciones")
public class Donacion {
    @Id
    private String id;
    private String usuarioId;
    private String fechaDonacion;
    private List<Object> productos;
    private int Cantidad;

    public Donacion() {
    }

    public Donacion(String id, String usuarioId, String fechaDonacion, List<Object> productos, int Cantidad) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.fechaDonacion = fechaDonacion;
        this.productos = productos;
        this.Cantidad = Cantidad;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getFechaDonacion() {
        return fechaDonacion;
    }

    public void setFechaDonacion(String fechaDonacion) {
        this.fechaDonacion = fechaDonacion;
    }

    public List<Object> getProductos() {
        return productos;
    }

    public void setProductos(List<Object> productos) {
        this.productos = productos;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
}