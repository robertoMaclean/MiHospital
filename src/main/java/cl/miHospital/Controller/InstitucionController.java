package cl.miHospital.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.miHospital.model.Institucion;
import cl.miHospital.service.InstitucionService;

@RestController
public class InstitucionController {
	
	@RequestMapping(value="/instituciones", method=RequestMethod.GET)
	public List<Institucion> getInsituciones(){	
		return InstitucionService.getInstituciones();
	}
	
}
