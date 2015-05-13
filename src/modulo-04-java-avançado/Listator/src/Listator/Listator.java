package Listator;

import java.io.File; 

public class Listator {

	public static void main(String[] args) {
		  validaParametros(args);
		  String diretorio = args[0];

		  String[] files = buscaArquivosDiretorio(diretorio);
		    
		  imprimeArquivos(files);

	}
		
	private static void validaParametros(String[] args) {
	    if(args.length == 0){
	        throw new IllegalStateException("Nenhum diretório informado");
	    }
	}
	
	private static void imprimeArquivos(String[] files) {
	    for(String file : files){
	        System.out.println(file);
	    }
	}
	
	public static String[] buscaArquivosDiretorio(String diretorio) {
	    return new File(diretorio).list();
	}
}