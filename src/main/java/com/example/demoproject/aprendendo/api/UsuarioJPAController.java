package com.example.demoproject.aprendendo.api;

import com.example.demoproject.aprendendo.dao.UsuarioJPA;
import com.example.demoproject.aprendendo.model.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioJPAController {

	private final UsuarioJPA usuarioJPA;

	public UsuarioJPAController(UsuarioJPA usuarioJPA) {
		this.usuarioJPA = usuarioJPA;
	}

	@GetMapping("/usuariojpa")
	Iterable<Usuario> todosUsuarios() {
		return usuarioJPA.findAll();
	}
}
