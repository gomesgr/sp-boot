package com.example.demoproject.aprendendo.api;

import com.example.demoproject.aprendendo.model.Usuario;
import com.example.demoproject.aprendendo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/usuario")
@RestController
public class UsuarioController {
    private final UsuarioService USUARIO_SERVICE;

    @Autowired
    public UsuarioController(UsuarioService usuario_service) {
        USUARIO_SERVICE = usuario_service;
    }

    @PostMapping
    public void adicionarUsuario(@RequestBody Usuario usuario) {
        USUARIO_SERVICE.adicionarUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> listarTodosUsuarios() {
        return USUARIO_SERVICE.listarTodosUsuarios();
    }

    @DeleteMapping(path = "{id}")
    public int deletarUsuarioPorId(@PathVariable("id") UUID id) {
        return USUARIO_SERVICE.deletarUsuarioPorId(id);
    }

    @GetMapping(path = "{id}")
    Usuario listarUsuarioPorId(@PathVariable("id") UUID id) {
        System.out.println("fjihdsfhdhjg");
        System.out.println(id);
        return USUARIO_SERVICE.listarUsuarioPorId(id);
    }
}
