package cl.miHospital.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import cl.miHospital.model.Usuario;
import cl.miHospital.object.UserLoginRequest;
import cl.miHospital.object.UserLoginResponse;
import cl.miHospital.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@RequestMapping(value="/usuario", method=RequestMethod.GET)
	public List<Usuario> getUsuarios(){
		return UsuarioService.getUsuarios();
	}
	
	@RequestMapping(value="/usuario/{rut}", method=RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUsuario(@PathVariable String rut) {	
		if(UsuarioService.deleteUsuario(rut)){
			return new ResponseEntity<Object>(HttpStatus.OK );
		}
		ObjectMapper mapper = new ObjectMapper();
        ObjectNode message = mapper.createObjectNode();
        message.put("message", "No se pudo realizar la solicitud. Hubo un problema en el servidor.");
		return new ResponseEntity<Object>(message, HttpStatus.BAD_REQUEST);
    }
    
    @RequestMapping(value="/usuario", method=RequestMethod.POST, consumes="application/x-www-form-urlencoded")
    public ResponseEntity<Object> insertUsuario(HttpServletRequest request) {
    
    	ObjectMapper mapper = new ObjectMapper();
        ObjectNode message = mapper.createObjectNode();
    	if(UsuarioService.insertUsuario(request, message)){
    		return new ResponseEntity<Object>(HttpStatus.OK );
    	}
    	
        return new ResponseEntity<Object>(message, HttpStatus.BAD_REQUEST);
    }  
    
    @RequestMapping(value="/usuario/{rut}", method=RequestMethod.POST, consumes="application/x-www-form-urlencoded")
    public ResponseEntity<Object> updateUsuario(HttpServletRequest request, @PathVariable String rut) {
    
    	ObjectMapper mapper = new ObjectMapper();
        ObjectNode message = mapper.createObjectNode();
        //System.out.println(request.getParameter("rut"));
    	if(UsuarioService.updateUsuario(request, rut, message)){
    		return new ResponseEntity<Object>(HttpStatus.OK );
    	}
    	
        return new ResponseEntity<Object>(message, HttpStatus.BAD_REQUEST);
    }  
    
    @RequestMapping(value="/login", method=RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Object> login(@RequestBody UserLoginRequest userReq){
		
		String username = userReq.getUsername();
		String password = userReq.getPassword();
		ObjectMapper mapper = new ObjectMapper();
        ObjectNode message = mapper.createObjectNode();
		Usuario user = UsuarioService.correctPassword(username, password, message);
		
		if(user!=null){
			UserLoginResponse userRes = UsuarioService.fillUserResponse(user);
			return new ResponseEntity<Object>(userRes, HttpStatus.OK );
		}
		return new ResponseEntity<Object>(message, HttpStatus.BAD_REQUEST);
	}
    
    @RequestMapping(value="/usuario/set_password/{rut}", method=RequestMethod.POST, consumes="application/x-www-form-urlencoded")
    public ResponseEntity<Object> updateUsuarioPassword(HttpServletRequest request, @PathVariable String rut) {
    
    	ObjectMapper mapper = new ObjectMapper();
        ObjectNode message = mapper.createObjectNode();
        //System.out.println(request.getParameter("rut"));
    	if(UsuarioService.SetPassword(request, message, rut)){
    		return new ResponseEntity<Object>(HttpStatus.OK );
    	}
    	
        return new ResponseEntity<Object>(message, HttpStatus.BAD_REQUEST);
    }  
}
