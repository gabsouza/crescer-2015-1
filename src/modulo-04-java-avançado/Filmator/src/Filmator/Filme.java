package Filmator;

import java.util.ArrayList;
import java.util.Scanner;

public class Filme {
	
 Scanner ler = new Scanner(System.in);
	 
 	 private String titulo;
	 private ArrayList<Ator> elenco = new ArrayList<>();
	 private Genero genero;
	 
	 public Filme (String titulo){
		 this.titulo = titulo;
	 }
	 
	 public Filme (String titulo, Genero genero){
		 this.titulo = titulo;
		 this.genero = genero;
	 }

	 public void AdicionaElenco(Ator ator){
		 elenco.add(ator); 
	 }

	public String  toString(){
		return null;
		
	}
	
	public ArrayList<Ator> elenco (String nome){
		ArrayList<Ator> elencoNovo = new ArrayList<>();
		for (Ator ator : elencoNovo) {
			if (ator.getNome().contains(nome)){
				elencoNovo.add(ator);
			}
		}	
		
		return elencoNovo;
	}
	
}
