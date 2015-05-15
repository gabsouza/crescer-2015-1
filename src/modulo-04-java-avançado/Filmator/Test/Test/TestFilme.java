package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Filmator.Filme;

public class TestFilme {
	
	@Test
	public void TesteToString (){
		String tituloEsperado = "Avengers";
		String mensagemEsperada = "Titulo: Avengers";
		Filme filme = new Filme(tituloEsperado);
		assertEquals (mensagemEsperada, filme.toString());
		assertEquals(tituloEsperado, filme.getTitulo());
	}
	
	@Test
	public void TesteFilme(){
		String tituloEsperado = "Avengers";
		Filme filme = new Filme(tituloEsperado);
		assertEquals (tituloEsperado, filme.getTitulo());
	}
}
