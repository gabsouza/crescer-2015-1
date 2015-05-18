package MestreCuca;

import java.util.ArrayList;
import java.util.List;

public class Livro implements LivroReceitas {
	
	private List<Receita> receitas = new ArrayList<>();

	@Override
	public void inserir(Receita receita) {
		if (validaNome(receita, receita)){
			receitas.add(receita);
		}
		
	}
	
	public boolean validaNome (Receita nome, Receita receita){
		if (receita != null){
			if (nome.getNome() != null && nome.getNome().trim().equals("") && nome.getNome() != null){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
		
	}

	@Override
	public void atualizar(String nome, Receita receitaAtualizada) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(String nome) {
		
		
	}

	@Override
	public List<Receita> getTodasReceitas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Receita buscaReceitaPeloNome(String nome) {
		try{
			for (Receita receita: receitas){
				if (receita.getNome().contains(nome)){
					return receita;
				}
			}
		}
		catch (ReceitaNaoEncontradaException e){
			System.out.println(e);
			return null;
		}
				return null;
			} else return null;
	}

}
