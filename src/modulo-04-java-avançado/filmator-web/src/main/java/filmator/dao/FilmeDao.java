package filmator.dao; //marlon loco batati e bata


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import filmator.model.Filme;

@Component
public class FilmeDao {

	
	@Inject
	private JdbcTemplate jdbcTemplate;
	

	public void inserir(Filme filme){
		jdbcTemplate.update("INSERT INTO Filme (nome) VALUES (?)", filme.getNome());
	}
	
	public List<Filme> buscaTodosFilmes(){

		return jdbcTemplate.query("SELECT nome FROM Filme", new RowMapper<Filme>(){
			@Override
			public Filme mapRow(ResultSet rs, int rowNum) throws SQLException {
				Filme filme = new Filme(rs.getString("nome"));
				return filme;
			}
		});
	}
	
	public List<Filme> buscaTodosFilmesJava8(){
		return jdbcTemplate.query("SELECT nome FROM Filme", (ResultSet rs, int rowNum) -> {	
			Filme filme = new Filme(rs.getString("nome"));
			return filme;
		});
		
	}
	
}
