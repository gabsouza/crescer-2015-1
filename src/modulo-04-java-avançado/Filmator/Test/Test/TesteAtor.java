package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Filmator.Ator;

public class TesteAtor {
	
	@Test
	public void TestToString(){
		 String nomeEsperado = "Fernando";
		 int idadeEsperada = 16;
		 	Ator ator = new Ator(nomeEsperado, idadeEsperada);
		 	String mensagemEsperada = "Nome: Fernando Idade: 16";
		 	assertEquals (mensagemEsperada, ator.toString());
	        assertEquals(nomeEsperado, ator.getNome());
	        assertEquals(idadeEsperada, ator.getIdade());
		
		
		
	}
	
	@Test
	public void AtorRecebeNome(){
		 String nomeEsperado = "Fernando";
	        Ator nome = new Ator (nomeEsperado);
	        assertEquals(nomeEsperado, nome.getNome());
	}
	
	@Test
	public void AtorRecebeNomeEIdade(){
		 String nomeEsperado = "Fernando";
		 int idadeEsperada = 16;
		 	Ator ator = new Ator(nomeEsperado, idadeEsperada);
	        assertEquals(nomeEsperado, ator.getNome());
	        assertEquals(idadeEsperada, ator.getIdade());
		
	}
	
	

}
