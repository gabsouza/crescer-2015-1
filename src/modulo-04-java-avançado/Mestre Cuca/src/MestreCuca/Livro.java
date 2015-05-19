package MestreCuca;

import java.util.ArrayList;
import java.util.List;

public class Livro implements LivroReceitas {
	
	private List<Receita> receitas = new ArrayList<>();

	@Override
	public void inserir(Receita receita) {
		if (validaNome(receita.getNome(), receita)){
			receitas.add(receita);
		}
		
	}
	
	public boolean validaNome (String nome, Receita receita){
		if (receita != null){
			if (receita.getNome() != null && receita.getNome().trim().equals("") && receita.getNome() != null){
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
		if (validaNome(nome, receitaAtualizada)){
			excluir(nome);
			receitas.add(receitaAtualizada);
		}
		
	}

	@Override
	public void excluir(String nome) {
		try {
			Receita excluirReceita = buscaReceitaPeloNome(nome);
			this.receitas.remove(excluirReceita);
		} catch (ReceitaNaoEncontradaExcepcion e){
			System.out.println(e);
		}
		
	}

	@Override
	public List<Receita> getTodasReceitas() {
		return receitas;
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
		catch (ReceitaNaoEncontradaExcepcion e){
			System.out.println(e);
			return null;
		}
				return null;
	}

}
