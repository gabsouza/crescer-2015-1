package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import java.util.List;






import MestreCuca.Ingrediente;
import MestreCuca.IngredienteReceita;
import MestreCuca.Instrucao;
import MestreCuca.Livro;
import MestreCuca.Receita;
import MestreCuca.UnidadeMedida;

public class TestLivro {
	
	@Test
	public void testeInserirReceita() throws Exception {
		Instrucao instrucao1 = new Instrucao("Misture tudo");
		Instrucao instrucao2 = new Instrucao("Bata a massa");
		Ingrediente ovo = new Ingrediente("Ovo", 0.30);
		Ingrediente leite = new Ingrediente("leite", 2.00);
		IngredienteReceita ingrediente1 = new IngredienteReceita(ovo, 6.00, 
														UnidadeMedida.UNIDADE);
		IngredienteReceita ingrediente2 = new IngredienteReceita(leite, 2.00, 
														UnidadeMedida.XICARA);
		List<IngredienteReceita> ingredientes = new ArrayList<>();
		ingredientes.add(ingrediente1);
		ingredientes.add(ingrediente2);
		
		List<Instrucao> instrucao = new ArrayList<>();
		instrucao.add(instrucao1);
		instrucao.add(instrucao2);
		
		String nomeReceita = "Bolo de Chocolate";
		
		Receita receita = new Receita(nomeReceita, ingredientes, instrucao);
		Livro livro = new Livro();

		livro.inserir(receita);
		assertEquals(receita, livro.getTodasReceitas().get(0) );
	}
	
	@Test
	public void testeAtualizar() throws Exception{
		Instrucao instrucao1 = new Instrucao("Misture tudo");
		Instrucao instrucao2 = new Instrucao("Bata a massa");
		Ingrediente ovo = new Ingrediente("Ovo", 0.30);
		Ingrediente leite = new Ingrediente("leite", 2.00);
		IngredienteReceita ingrediente1 = new IngredienteReceita(ovo, 6.00, 
														UnidadeMedida.UNIDADE);
		IngredienteReceita ingrediente2 = new IngredienteReceita(leite, 2.00, 
														UnidadeMedida.XICARA);
		List<IngredienteReceita> ingredientes = new ArrayList<>();
		ingredientes.add(ingrediente1);
		ingredientes.add(ingrediente2);
		
		List<Instrucao> instrucao = new ArrayList<>();
		instrucao.add(instrucao1);
		instrucao.add(instrucao2);
		
		String receitaAntiga = "Bolo de Chocolate";
		
		Receita receita = new Receita(receitaAntiga, ingredientes, instrucao);
		Livro livro = new Livro();

		livro.inserir(receita);
		assertEquals(receita, livro.getTodasReceitas().get(0) );
		
	}
	
		
	
	
	
	}

