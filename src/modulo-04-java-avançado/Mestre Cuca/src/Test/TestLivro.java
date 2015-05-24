package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import mestrecuca.Ingrediente;
import mestrecuca.IngredienteReceita;
import mestrecuca.Instrucao;
import mestrecuca.Livro;
import mestrecuca.Receita;
import mestrecuca.UnidadeMedida;

import org.junit.Test;

import java.util.List;

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
		IngredienteReceita ingrediente1 = new IngredienteReceita(ovo, 6.00, UnidadeMedida.UNIDADE);
		IngredienteReceita ingrediente2 = new IngredienteReceita(leite, 2.00, UnidadeMedida.XICARA);
		
		List<IngredienteReceita> ingredientes = new ArrayList<>();
		ingredientes.add(ingrediente1);
		ingredientes.add(ingrediente2);
		
		List<Instrucao> instrucao = new ArrayList<>();
		instrucao.add(instrucao1);
		instrucao.add(instrucao2);
		
		String receitaAntiga = "Bolo";
		
		Receita receita = new Receita(receitaAntiga, ingredientes, instrucao);
		
		Instrucao instrucaonova1 = new Instrucao("Separe a clara da gema antes de misturar os ingredientes");
		Instrucao instrucaonova2 = new Instrucao("Bata tudo em uma batedeira");
		Ingrediente chocolate = new Ingrediente ("Chocolate", 5.00);
		Ingrediente farinha = new Ingrediente ("Farinha", 2.00);
		IngredienteReceita ingredienteChocolate = new IngredienteReceita (chocolate, 0.100, UnidadeMedida.GRAMA);
		IngredienteReceita ingredienteFarinha = new IngredienteReceita (farinha, 0.400, UnidadeMedida.GRAMA);
		
		
		List<IngredienteReceita> ingredientesNovos = new ArrayList<>();
		ingredientesNovos.add(ingredienteChocolate);
		ingredientesNovos.add(ingredienteFarinha);
		
		List<Instrucao> instrucaoNova = new ArrayList<>();
		instrucaoNova.add(instrucaonova1);
		instrucaoNova.add(instrucaonova2);
		
		String receitaNova = "Bolo de Chocolate";
		
		Receita receita2 = new Receita (receitaNova, ingredientesNovos, instrucaoNova);
		Livro livro = new Livro();

		livro.inserir(receita);
		livro.atualizar("Bolo", receita2);
		assertEquals(receita, livro.getTodasReceitas().get(0) );
		
	}
	
	@Test
	public void testExcluir() throws Exception{
		Receita receita = new Receita ("Bolo");
		Livro livro = new Livro();
		
		livro.inserir(receita);
		assertEquals(1, livro.getTodasReceitas().size() );
		
		livro.excluir("Bolo");
		List<Receita> esperado = new ArrayList<>();
		assertEquals(esperado, livro.getTodasReceitas() );
		assertEquals(0, livro.getTodasReceitas().size() );
	}
	
	@Test
	public void testBuscarReceitaPeloNome() throws Exception{
		Receita receita = new Receita ("Sopa");
		Livro livro = new Livro();
		
		livro.inserir(receita);
		Receita resultado = livro.buscaReceitaPeloNome(receita.getNome());
		assertEquals(receita, resultado);
		
	}
	
	
	}

