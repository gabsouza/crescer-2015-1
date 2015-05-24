package Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import mestrecuca.Ingrediente;
import mestrecuca.IngredienteReceita;
import mestrecuca.Instrucao;
import mestrecuca.Livro;
import mestrecuca.Receita;
import mestrecuca.UnidadeMedida;

import org.junit.Test;

public class TestReceita {
	
	@Test
	public void testCalcularReceita(){
		Instrucao instrucao1 = new Instrucao("Misture tudo");
		Instrucao instrucao2 = new Instrucao("Bata a massa");
		
		Ingrediente ovo = new Ingrediente("Ovo", 0.30);
		Ingrediente leite = new Ingrediente("leite", 2.00);
		
		IngredienteReceita ingrediente1 = new IngredienteReceita(ovo, 6.00, UnidadeMedida.UNIDADE);
		IngredienteReceita ingrediente2 = new IngredienteReceita(leite, 2.00, UnidadeMedida.XICARA);
		
		List<IngredienteReceita> esperado = new ArrayList<>();
		esperado.add(ingrediente1);
		esperado.add(ingrediente2);
		
		List<Instrucao> instrucao = new ArrayList<>();
		instrucao.add(instrucao1);
		instrucao.add(instrucao2);
		
		String nome = "Bolo";
		Receita receita = new Receita(nome, esperado, instrucao);
		receita.calcularValorTotalReceita(esperado);
		Livro livro = new Livro();
		
		livro.inserir(receita);
		assertEquals(receita, livro.getTodasReceitas().get(0) );
	}

}
