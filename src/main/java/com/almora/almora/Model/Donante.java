package com.almora.almora.Model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
public class Donante extends Usuario {

    public Donante() {
        super();
    }

    public Donante(String idUsuario, String nombre, String correo, String password, String rol, String telefono) {
        super(idUsuario, nombre, correo, password, rol, telefono);
    }
}