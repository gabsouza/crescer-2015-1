package Filmator;

import java.util.HashMap;
import java.util.Map;

public class Netflox {
	
	private Map<Genero, Integer> estatisticas = new HashMap<Genero, Integer>();
	
	public void reproduzirFilme(Filme filme){
		System.out.println("Reproduzindo " +  filme.getTitulo());
	}
	
	public void gerarRelatorio(){
		
	}

}
