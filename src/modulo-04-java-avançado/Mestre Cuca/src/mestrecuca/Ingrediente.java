package mestrecuca;

public class Ingrediente {
	private String nome;
	private double quantidade;
	private double valor;
	private UnidadeMedida unidadeMedida;

	public Ingrediente(String nome, double quantidade,
			UnidadeMedida unidadeMedida) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.unidadeMedida = unidadeMedida;
	}

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

	public UnidadeMedida getUnidadeMedida() {
		return this.unidadeMedida;
	}

}
