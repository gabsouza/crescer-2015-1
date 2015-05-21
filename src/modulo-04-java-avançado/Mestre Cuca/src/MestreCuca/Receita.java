package MestreCuca;

import java.util.ArrayList;
import java.util.List;


public class Receita {
	
	private String nome;
	private List<IngredienteReceita> ingredientes = new ArrayList<>();
	private List<Instrucao> instrucao = new ArrayList<Instrucao>();
	private double valorTotal;

	public Receita(String nome, List<IngredienteReceita> ingredientes, List<Instrucao> instrucao) {		
		this.nome = nome;
		this.ingredientes = ingredientes;
		this.instrucao = instrucao;
		this.valorTotal = calcularValorTotalReceita(ingredientes);
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
	
	public double calcularValorTotalReceita (List<IngredienteReceita> ingredientes){
		valorTotal = 0;
		for (IngredienteReceita ingrediente: ingredientes ){
			valorTotal += ingrediente.getIngrediente().getValor();
		}
		return valorTotal;
			
		}


}
