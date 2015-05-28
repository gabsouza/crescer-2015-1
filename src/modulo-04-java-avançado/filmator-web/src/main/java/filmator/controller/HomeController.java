package filmator.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import filmator.dao.FilmeDao;
import filmator.model.Filme;

@Controller
public class HomeController {

	@Inject
	private FilmeDao filmeDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}

	// @RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	// public String cadastraFilme() {
	// return "cadastroFilmes";
	// }
	//
	// @ResponseBody //@ResponseBody faz transformar o retorno para JSON!
	// @RequestMapping(value = "/buscarTodos", method = RequestMethod.GET)
	// public List<Filme> buscarTodos(Model model) {
	// return filmeDao.buscaTodosFilmesJava8();
	// }
	//
	// @RequestMapping(value = "/inserir", method = RequestMethod.POST)
	// public String inserir(Model model, Filme filme) {
	// filmeDao.inserir(filme);
	// model.addAttribute("filmes", filmeDao.buscaTodosFilmesJava8());
	// model.addAttribute("mensagem", "Filme inserido com sucesso!");
	// return "cadastroFilmes";
	// }

}