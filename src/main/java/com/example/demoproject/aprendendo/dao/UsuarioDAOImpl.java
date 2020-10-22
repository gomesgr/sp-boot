package com.example.demoproject.aprendendo.dao;

import com.example.demoproject.aprendendo.exceptions.AprendendoAuthException;
import com.example.demoproject.aprendendo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;

@Repository("usuariodao")
public class UsuarioDAOImpl implements UsuarioDAO {

    private static final String SQL_INSERIR = "INSERT INTO usuario VALUES (?, ?, ?)";
    private static final String SQL_LISTAR_TODOS = "SELECT * FROM usuario";
    private static final String SQL_DELETAR_ID = "DELETE FROM usuario WHERE usuario_id = ?";
    private static final String SQL_LISTAR_POR_ID = "SELECT * FROM usuario WHERE usuario_id = ?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Optional<UUID> inserirUsuario(UUID uuid, Usuario usuario) {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(
                        SQL_INSERIR, Statement.RETURN_GENERATED_KEYS);
                ps.setObject(1, uuid);
                Pattern emailPattern = Pattern.compile("^(.+)@(.+)$");
                if (!emailPattern.matcher(usuario.getEmail()).matches()) {
                    throw new AprendendoAuthException("Email incorreto, tente novamente");
                }
                ps.setString(2, usuario.getNome());
                ps.setString(3, usuario.getEmail());
                return ps;
            }, keyHolder);
            return Optional.of((UUID) keyHolder.getKeys().get("usuario_id"));
        } catch (Exception e) {
            throw new AprendendoAuthException("Dados invalidos. Falha ao inserir \n" + e);
        }
    }

    private RowMapper<Usuario> usuarioRowMapper = ((rs, rowNum) ->
            new Usuario (
            (UUID) rs.getObject("usuario_id"),
            rs.getString("nome"),
            rs.getString("email")
    ));

    @Override
    public List<Usuario> listarTodosUsuarios() {
        return jdbcTemplate.query(SQL_LISTAR_TODOS, usuarioRowMapper);
    }

    @Override
    public int deletarUsuarioPorId(UUID id) {
        return jdbcTemplate.update(SQL_DELETAR_ID, id);
    }

    @Override
    public Usuario listarUsuarioPorId(UUID id) {
        Usuario us = jdbcTemplate.queryForObject(SQL_LISTAR_POR_ID, new Object[]{id}, usuarioRowMapper);
        System.out.println("USUARIO: ");
        System.out.println(us);
        return us;
    }
}
