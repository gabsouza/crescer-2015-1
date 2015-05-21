package MestreCuca;

public class Ingrediente {
	private String nome;
	private double quantidade;
	private double valor;

	public double getQuantidade() {
		return quantidade;
	}
	
	public Ingrediente(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public double getValor() {
		return valor;
	}
	
}
