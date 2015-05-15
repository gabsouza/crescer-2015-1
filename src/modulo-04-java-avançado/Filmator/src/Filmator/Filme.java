package Filmator;

import java.util.List;
import java.util.ArrayList;

public class Filme {
	 
 	 private String titulo;
	 private List<Ator> elenco = new ArrayList<>();
	 private Genero genero;
	 
	 public Filme (String titulo){
		 this.titulo = titulo;
	 }
	 
	 public Filme (String titulo, Genero genero){
		 this.titulo = titulo;
		 this.genero = genero;
	 }

	 public void adicionaElenco(Ator ator){
		 this.elenco.add(ator); 
	 }

	 @Override
	 public String  toString(){
		String mensagem = String.format("Titulo: %s",
				this.titulo
				);
		return mensagem;
		
	 }
	
	 public List<Ator> buscaAtorPeloNome (String nome){
		List<Ator> elencoNovo = new ArrayList<Ator>();
		for (Ator ator : elencoNovo) {
			if (ator.getNome().contains(nome)){
				elencoNovo.add(ator);
			}
		}	
		
		return elencoNovo;
	 }
	
	 public String getTitulo(){
		return this.titulo;
	 }
	
	 public Genero getGenero(){
		return this.genero;
	 }
	 
	 public List<Ator> getElenco (){
		 return this.elenco;
	 }
	
}
