package MestreCuca;

public class IngredienteReceita {
	
	private Ingrediente ingrediente;
	private double quantidade;
	private UnidadeMedida unidadeMedida;
	
	public IngredienteReceita(Ingrediente ingrediente, double qtd, UnidadeMedida unidade){
		this.ingrediente = ingrediente;
		this.quantidade = qtd;
		this.unidadeMedida = unidade;
	}
	
	public Ingrediente getIngrediente(){
		return this.ingrediente;
	}
	public double getQuantidade(){
		return this.quantidade;
	}
	public UnidadeMedida getUnidadeMedida() {
		return this.unidadeMedida;
	}

}
