package cl.miHospital.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import cl.miHospital.service.PacienteService;
import cl.miHospital.service.RetiroMedicamentoService;
import cl.miHospital.service.UsuarioService;
import cl.miHospital.model.Retiro_medicamento;


@RestController
public class RetiroMedicamentoController {
	
	@RequestMapping(value="/retiro_medicamento", method=RequestMethod.GET)
    public List<Retiro_medicamento> getMedicamentos() {
		return RetiroMedicamentoService.getRetiroMedicamento();
    }
    
    @RequestMapping(value="/retiro_medicamento/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Object> deleteRetiroMedicamento(@PathVariable Integer id) {	
		if(RetiroMedicamentoService.deleteRetiroMedicamento(id)){
			return new ResponseEntity<Object>(HttpStatus.OK );
		}
		ObjectMapper mapper = new ObjectMapper();
        ObjectNode message = mapper.createObjectNode();
        message.put("message", "No se pudo realizar la solicitud. Hubo un problema en el servidor.");
		return new ResponseEntity<Object>(message, HttpStatus.BAD_REQUEST);
    }
    
    @RequestMapping(value="/retiro_medicamento", method=RequestMethod.POST, consumes="application/x-www-form-urlencoded")
    public ResponseEntity<Object> insertMedicamento(HttpServletRequest request) {
    	Retiro_medicamento retiroMedicamento = RetiroMedicamentoService.fillRetiroMedicamento(request);
    	if(RetiroMedicamentoService.insertRetiroMedicamento(retiroMedicamento)){
    		return new ResponseEntity<Object>(HttpStatus.OK );
    	}
    	ObjectMapper mapper = new ObjectMapper();
        ObjectNode message = mapper.createObjectNode();
        message.put("message", "No se pudo realizar la solicitud. Hubo un problema en el servidor.");
        return new ResponseEntity<Object>(message, HttpStatus.BAD_REQUEST);
    }  
    
    @RequestMapping(value="/retiro_medicamento/{id}", method=RequestMethod.POST, consumes="application/x-www-form-urlencoded")
    public ResponseEntity<Object> updateRetiroMedicamento(HttpServletRequest request, @PathVariable Integer id) {
    
    	ObjectMapper mapper = new ObjectMapper();
        ObjectNode message = mapper.createObjectNode();
        //System.out.println(request.getParameter("rut"));
    	if(RetiroMedicamentoService.updateRetiroMedicamento(request, id, message)){
    		return new ResponseEntity<Object>(HttpStatus.OK );
    	}
    	
        return new ResponseEntity<Object>(message, HttpStatus.BAD_REQUEST);
    }  
    
    @RequestMapping(value="/retiro_medicamento/paciente_exist/{rut}", method=RequestMethod.GET)
    public boolean deleteRetiroMedicamento(@PathVariable String rut) {	
		return (PacienteService.getPaciente(rut)!=null);	
    }
	
}
