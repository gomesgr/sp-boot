package com.example.demoproject.aprendendo.dao;

import com.example.demoproject.aprendendo.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UsuarioJPA extends CrudRepository<Usuario, UUID> {
}
