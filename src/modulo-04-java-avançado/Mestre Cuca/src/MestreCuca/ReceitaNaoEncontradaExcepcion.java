package MestreCuca;

public class ReceitaNaoEncontradaExcepcion extends RuntimeException{
	
	public ReceitaNaoEncontradaExcepcion(){
		super("Receita n�o encontrada");
	}

}
