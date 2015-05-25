package mestrecuca;

import java.util.ArrayList;
import java.util.List;

public class Receita {

	private String nome;
	private List<Ingrediente> ingredientes = new ArrayList<>();
	private List<Instrucao> instrucao = new ArrayList<Instrucao>();
	private double valorTotal;

	public Receita(String nome, List<Ingrediente> ingredientes,
			List<Instrucao> instrucao) {
		this.nome = nome;
		this.ingredientes = ingredientes;
		this.instrucao = instrucao;
		this.valorTotal = calcularValorTotalReceita(ingredientes);
	}

	public Receita(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public List<Instrucao> getInstrucao() {
		return instrucao;
	}

	public double calcularValorTotalReceita(List<Ingrediente> ingredientes) {
		valorTotal = 0;
		for (Ingrediente ingrediente : ingredientes) {
			valorTotal += ingrediente.getValor();
		}
		return valorTotal;

	}

	public boolean contemIngredienteProibido(List<String> ingredientesProibidos) {
		for (Ingrediente ingrediente : ingredientes) {
			if (ingredientesProibidos.contains(ingrediente.getNome())) {
				return true;
			}
		}
		return false;
	}

}
