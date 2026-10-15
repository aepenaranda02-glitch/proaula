package com.almora.almora.Model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "admins")
public class Admin extends Usuario {

    public Admin() {
        super();
    }

    public Admin(String idUsuario, String nombre, String correo, String password, String rol, String telefono) {
        super(idUsuario, nombre, correo, password, rol, telefono);
    }
}
