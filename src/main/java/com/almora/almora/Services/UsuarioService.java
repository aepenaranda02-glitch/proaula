package com.almora.almora.Services;

import com.almora.almora.Model.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    Usuario saveUsuario(Usuario usuario);

    List<Usuario> getAllUsuarios();

    Optional<Usuario> getUsuarioById(String id);

    Usuario updateUsuario(String id, Usuario usuario);

    void deleteUsuario(String id);

    Optional<Usuario> getUsuarioByCorreo(String correo);

    Usuario saveAdmin(Usuario usuario);

}
