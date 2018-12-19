package cl.miHospital.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import cl.miHospital.model.Usuario;
import cl.miHospital.util.HibernateUtility;


public class UsuarioService {
	
	public static Usuario getUsuario(String rut){
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query q = session.createQuery("from Usuario u where u.rut='" + rut + "'");
        Usuario usuario =  (Usuario) q.uniqueResult();	 
        return usuario;
	}
	
	public static List<Usuario> getUsuarios(){
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query q = session.createQuery("from Usuario");
        List<Usuario> usuarios =   q.list();	 
        return usuarios;
	}
	
	public static boolean insertUsuario(Usuario usuario){
		try{
			SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
			Session session = sessionFactory.openSession(); 
			Transaction tx1 = session.beginTransaction();
			session.save(usuario);
	        tx1.commit();
	        session.close();
	        return true;
	        
		}catch(Exception e){
			e.printStackTrace();
		}
        return false;
	}
	
	public static Usuario fillUsuario(HttpServletRequest request){
		
		String rut = request.getParameter("rut");
		String nombres = request.getParameter("nombres");
		String apellido = request.getParameter("apellido");
		String correo = request.getParameter("correo");
		String contrasena = request.getParameter("contrasena");
		Integer esPaciente = Integer.parseInt(request.getParameter("esPaciente"));
		Integer es_some = Integer.parseInt(request.getParameter("es_some"));
		String creado_por = request.getParameter("creado_por");
		Integer id_institucion = Integer.parseInt(request.getParameter("id_institucion"));
		Integer primer_ingreso = Integer.parseInt(request.getParameter("primer_ingreso"));
		Integer acepta_condiciones = Integer.parseInt(request.getParameter("acepta_condiciones"));
		String telefono = request.getParameter("telefono");
		
		Usuario usuario = new Usuario();
		usuario.setNombres(nombres);
		usuario.setApellido(apellido);
		usuario.setContrasena(contrasena);
		usuario.setCorreo(correo);
		usuario.setCreado_por(creado_por);
		usuario.setEs_some(es_some);
		usuario.setEsPaciente(esPaciente);
		usuario.setId_institucion(id_institucion);
		usuario.setPrimer_ingreso(primer_ingreso);
		usuario.setAcepta_condiciones(acepta_condiciones);
		usuario.setTelefono(telefono);
		usuario.setRut(rut);
		
		return usuario;
	}
	
	public static boolean deleteRetiroMedicamento(String rut){
		try{
			SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
	        Session session = sessionFactory.openSession();
	        Transaction tx1 = session.beginTransaction();
	        Usuario usuario = getUsuario(rut);
			session.delete(usuario);
	        tx1.commit();
	        return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}		
	}
}
