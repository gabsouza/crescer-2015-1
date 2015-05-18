package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Filmator.Ator;
import Filmator.Filme;
import Filmator.Genero;

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
	
	@Test //terminar
	public void TesteFilmeComGenero(){
	String tituloEsperado = "Avengers";
	Genero generoEsperado = Genero.ACAO;
	Filme filme = new Filme (tituloEsperado);
	assertEquals ()
	}
	
	@Test // terminar
	public void TesteAdicionaElenco(){
		Ator ator = new Ator("Gabriel");
		Filme filme = new Filme("Avengers");
		filme.adicionaElenco(ator);
		
		assertEquals (ator, filme.getElenco().get(0));
	}
	
		assertEquals("Tamanho do elenco de um novo filme deve ser zero", 1, filme.getElenco().size());
	}
}
