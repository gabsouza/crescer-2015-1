package Filmator;


public class Ator {

	private String nome;
	private int idade;
	
	public String toString(){
		
		String mensagem = String.format("Nome: %s Idade: %d",
				this.nome,
				this.idade
				);
		return mensagem;
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
