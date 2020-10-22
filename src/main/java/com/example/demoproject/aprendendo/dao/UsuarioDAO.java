package com.example.demoproject.aprendendo.dao;

import com.example.demoproject.aprendendo.model.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioDAO {
    Optional<UUID> inserirUsuario(UUID uuid, Usuario usuario);

    default Optional<UUID> inserirUsuario(Usuario usuario) {
        UUID uuid = UUID.randomUUID();
        return inserirUsuario(uuid, usuario);
    }

    List<Usuario> listarTodosUsuarios();

    Usuario listarUsuarioPorId(UUID id);

    int deletarUsuarioPorId(UUID id);

}
