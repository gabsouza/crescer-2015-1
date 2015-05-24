package mestrecuca;

public class IngredienteReceita {
	
	private Ingrediente ingrediente;
	private double quantidade;
	private UnidadeMedida unidadeMedida;
	
	public IngredienteReceita(Ingrediente ingrediente, double quantidade, UnidadeMedida unidadeMedida){
		this.ingrediente = ingrediente;
		this.quantidade = quantidade;
		this.unidadeMedida = unidadeMedida;
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
