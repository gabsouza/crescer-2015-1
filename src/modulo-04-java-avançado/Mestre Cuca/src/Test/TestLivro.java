package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import mestrecuca.Ingrediente;
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

		Ingrediente ingrediente1 = new Ingrediente("ovo", 6.00, UnidadeMedida.UNIDADE);
		Ingrediente ingrediente2 = new Ingrediente("leite", 2.00, UnidadeMedida.XICARA);
		List<Ingrediente> ingredientes = new ArrayList<>();
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
		Ingrediente ingrediente1 = new Ingrediente("ovo", 6.00, UnidadeMedida.UNIDADE);
		Ingrediente ingrediente2 = new Ingrediente("leite", 2.00, UnidadeMedida.XICARA);
		
		List<Ingrediente> ingredientes = new ArrayList<>();
		ingredientes.add(ingrediente1);
		ingredientes.add(ingrediente2);
		
		List<Instrucao> instrucao = new ArrayList<>();
		instrucao.add(instrucao1);
		instrucao.add(instrucao2);
		
		String receitaAntiga = "Bolo";
		
		Receita receita = new Receita(receitaAntiga, ingredientes, instrucao);
		
		Instrucao instrucaonova1 = new Instrucao("Separe a clara da gema antes de misturar os ingredientes");
		Instrucao instrucaonova2 = new Instrucao("Bata tudo em uma batedeira");
		Ingrediente ingredienteChocolate = new Ingrediente ("chocolate", 0.100, UnidadeMedida.GRAMA);
		Ingrediente ingredienteFarinha = new Ingrediente ("farinha", 0.400, UnidadeMedida.GRAMA);
		
		List<Ingrediente> ingredientesNovos = new ArrayList<>();
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
	
	@Test
	public void testProtecaoAlergicos(){
		Ingrediente ingredienteChocolate = new Ingrediente ("chocolate", 0.100, UnidadeMedida.GRAMA);
		Ingrediente ingredienteFarinha = new Ingrediente ("farinha", 0.400, UnidadeMedida.GRAMA);
		Ingrediente castanha = new Ingrediente("castanha", 3, UnidadeMedida.UNIDADE);
		
		List<Ingrediente> ingredientesSem = new ArrayList<>();
		ingredientesSem.add(ingredienteChocolate);
		ingredientesSem.add(ingredienteFarinha);
		
		List<Ingrediente> ingredientesCom = new ArrayList<>();
		ingredientesCom.add(ingredienteChocolate);
		ingredientesCom.add(ingredienteFarinha);
		ingredientesCom.add(castanha);
		
		
		Receita receitaSem = new Receita ("Sopa", ingredientesSem);
		Receita receitaCom = new Receita("Cupcake do mal");
		Livro livro = new Livro();
		
		livro.inserir(receitaSem);
		livro.inserir(receitaCom);
		
		assertEquals();
		
		
	}
	
	
	}

