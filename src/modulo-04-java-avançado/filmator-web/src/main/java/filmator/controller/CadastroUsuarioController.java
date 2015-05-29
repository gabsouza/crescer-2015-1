package filmator.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.UsuarioDao;
import filmator.model.Usuario;

@Controller
public class CadastroUsuarioController {

	@Inject
	UsuarioDao usuarioDao;

	@RequestMapping(value = "/cadastroUsuario", method = RequestMethod.GET)
	public String cadastroUsuario() {
		return "cadastroUsuario";
	}

	@RequestMapping(value = "/cadastrarUsuario", method = RequestMethod.POST)
	public String cadastroUsuarioInserir(Model model, Usuario usuario) {
		usuarioDao.inserir(usuario);
		return "cadastroUsuario";
	}

}
