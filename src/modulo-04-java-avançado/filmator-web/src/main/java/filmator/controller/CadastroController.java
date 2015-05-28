package filmator.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;
import filmator.model.Filme;
import filmator.model.Genero;

@Controller
public class CadastroController {

	@Inject
	FilmeDao filmeDao;

	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String cadastro(Model model) {
		model.addAttribute("generos", Genero.values());
		return "cadastroFilmes";
	}
	
	@RequestMapping(value = "/cadastrarFilme", method = RequestMethod.POST)
	public String cadastro(Model model, Filme filme) {
		filmeDao.inserir(filme);
		return "cadastroFilmes";
	}

}