package MestreCuca;

import java.util.ArrayList;
import java.util.List;
public class Receita {

	private String nome;
	private List<Ingrediente> ingredientes = new ArrayList<>();
	private List<Instrucao> instrucao = new ArrayList<>();
	
	public String getNome(){
		return nome;
	}
	
	public List<Ingrediente> getIngredientes(){
		return ingredientes;
	}
	
	public List<Instrucao> getInstrucao (){
		return instrucao;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
}
