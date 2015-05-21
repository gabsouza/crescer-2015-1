package MestreCuca;

import java.util.ArrayList;
import java.util.List;


public class Receita {
	
	private String nome;
	private List<IngredienteReceita> ingredientes = new ArrayList<>();
	private List<Instrucao> instrucao = new ArrayList<Instrucao>();

	public Receita(String nome, List<IngredienteReceita> ingredientes, List<Instrucao> instrucao) {		
		this.nome = nome;
		this.ingredientes = ingredientes;
		this.instrucao = instrucao;
	}
	
	public Receita (String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<IngredienteReceita> getIngredientes(){
			return ingredientes;
	}	
	public List<Instrucao> getInstrucao(){
		return instrucao;
	}

}
