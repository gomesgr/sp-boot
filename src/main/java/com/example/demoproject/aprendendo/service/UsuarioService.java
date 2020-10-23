package com.example.demoproject.aprendendo.service;

import com.example.demoproject.aprendendo.dao.UsuarioDAO;
import com.example.demoproject.aprendendo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    private final UsuarioDAO USUARIO_DAO;

    @Autowired
    public UsuarioService(@Qualifier("usuariodao") UsuarioDAO usuarioDao) {
        USUARIO_DAO = usuarioDao;
    }

    public Optional<UUID> adicionarUsuario(Usuario usuario) {
        return USUARIO_DAO.inserirUsuario(usuario);
    }

    public List<Usuario> listarTodosUsuarios() {
        return USUARIO_DAO.listarTodosUsuarios();
    }

    public int deletarUsuarioPorId(UUID id) {
        return USUARIO_DAO.deletarUsuarioPorId(id);
    }

    public Usuario listarUsuarioPorId(UUID id) {
        return USUARIO_DAO.listarUsuarioPorId(id);
    }

    public int atualizarUsuarioPorId(UUID id, Usuario usuario) {
        return USUARIO_DAO.atualizarUsuarioPorId(id, usuario);
    }

}
