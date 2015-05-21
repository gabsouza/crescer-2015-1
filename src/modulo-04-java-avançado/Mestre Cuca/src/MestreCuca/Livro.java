package MestreCuca;

import java.util.ArrayList;
import java.util.List;

public class Livro implements LivroReceitas {
	private List<Receita> receitas = new ArrayList<Receita>();

	@Override
	public void inserir(Receita receita) {
		if (validaNome(receita.getNome(), receita)) {
			receitas.add(receita);
		}
	}

	public boolean validaNome(String nome, Receita receita) {
		if (receita != null) {
			if (receita.getNome() != null
					&& !receita.getNome().trim().equals("")) {
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
		if (validaNome(nome, receitaAtualizada)) {
		for (Receita receita : receitas) {
			if (receita.getNome() == receitaAtualizada.getNome()) {
				receita = receitaAtualizada;
			}
		}
	}}

	@Override
	public void excluir(String nome) {
		Receita receitaEncontrada = null;
		for (Receita receita : receitas) {
			if (receita.getNome().equals(nome)) {
				receitaEncontrada = receita;
			}
		}
		receitas.remove(receitaEncontrada);
	}

	@Override
	public List<Receita> getTodasReceitas() {
		return receitas;
	}

	@Override
	public Receita buscaReceitaPeloNome(String nome) {
		for (Receita receita : receitas) {
			if (receita.getNome().equals(nome)) {
				return receita;
			}
		}
		return null;
	}
}