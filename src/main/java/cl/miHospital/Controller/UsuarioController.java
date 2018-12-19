package cl.miHospital.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.miHospital.model.Usuario;
import cl.miHospital.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@RequestMapping(value="/usuarios", method=RequestMethod.GET)
	public List<Usuario> getUsuarios(){
		return UsuarioService.getUsuarios();
	}
}
