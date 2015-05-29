package filmator.model;

public class Filme {

	private int id;
	private String nome;
	private int anolancamento;
	private String sinopse;
	private String imagem;
	private Genero genero;

	public Filme() {

	}

	public Filme(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnolancamento() {
		return anolancamento;
	}

	public void setAnolancamento(int anolancamento) {
		this.anolancamento = anolancamento;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}
