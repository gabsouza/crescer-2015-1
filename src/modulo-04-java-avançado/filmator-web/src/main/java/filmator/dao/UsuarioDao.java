package filmator.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import filmator.model.Filme;
import filmator.model.Usuario;

@Component
public class UsuarioDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public void inserir(Usuario usuario) {
		jdbcTemplate.update(
				"INSERT INTO Usuario (username, senha) VALUES (?, ?)",
				usuario.getUsername(), usuario.getSenha());
	}

	public List<Usuario> buscaTodosUsuarios() {

		return jdbcTemplate.query("SELECT username FROM Usuario",
				new RowMapper<Usuario>() {
					@Override
					public Usuario mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Usuario usuario = new Usuario(rs.getString("username"));
						return usuario;
					}
				});
	}

}
