package filmator.model;

public enum Genero {
	ACAO("Ação"),
	ANIMACAO("Animação"), 
	AVENTURA ("Aventura"), 
	COMEDIA ("Comedia"),
	DRAMA ("Drama"),
	FAROESTE ("Faroeste"), 
	FICCAO_CIENTIFICA ("Ficção Científica"), 
	ROMANCE ("Romance"), 
	SUSPENSE ("Suspense"), 
	TERROR ("Terror"), 
	TRASH ("Trash");
	private String descricao;
	
	private Genero(String descricao) {
		this.descricao = descricao;
	}
	
	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
