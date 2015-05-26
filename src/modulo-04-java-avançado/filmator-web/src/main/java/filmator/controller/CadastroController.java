package filmator.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;
import filmator.model.Filme;

@Controller
public class CadastroController {

	@Inject
	FilmeDao filmeDao;
	
	@RequestMapping(value = "/inserir", method = RequestMethod.POST) 
	  public String inserir(Model model, Filme filme){
	    model.addAttribute("filmes", filmeDao.buscaTodosFilmesJava8());
	    model.addAttribute("mensagem", "Filme inserido com sucesso!");
	    return "home";
	  }

}