package Filmator;


public class Ator {

	private String nome;
	private int idade;
	
	public String toString(){
		return "Nome: " + this.nome + " Idade: " + this.idade;
	}
	
	public  Ator (String nome){
		this.nome = nome;
	}
	
	public Ator (String nome, int idade){
		this.nome = nome;
		this.idade = idade;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public int getIdade(){
		return this.idade;
	}
}
