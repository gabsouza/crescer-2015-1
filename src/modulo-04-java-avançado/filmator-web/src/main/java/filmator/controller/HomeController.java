package filmator.controller;

import java.util.Arrays;

import org.mockito.InjectMocks;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;
import filmator.model.Filme;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		FilmeDao dao = new FilmeDao();
		// DAO --- data acess object, convenção para classes que conectam no
		// banco
		// model.addAttribute("generos", Genero.values());
		
		return "nomeDoArquivo";
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Filme filme, Model model) {
		System.out.println(filme.getNome());
		return "nomeDoArquivo";
	}
}