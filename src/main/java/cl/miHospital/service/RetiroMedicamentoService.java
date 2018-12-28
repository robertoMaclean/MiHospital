package cl.miHospital.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.fasterxml.jackson.databind.node.ObjectNode;

import cl.miHospital.model.Institucion;
import cl.miHospital.model.Paciente;
import cl.miHospital.model.Retiro_medicamento;
import cl.miHospital.util.HibernateUtility;
import cl.miHospital.util.Utils;


public class RetiroMedicamentoService {

	public static List<Retiro_medicamento> getRetiroMedicamento(){
		String query = "from Retiro_medicamento";
		List<Retiro_medicamento> list = getObjects(query);
		return list;
	}
	
	public static boolean insertRetiroMedicamento(Retiro_medicamento retiroMedicamento){
		try{
			SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
			Session session = sessionFactory.openSession(); 
			Transaction tx1 = session.beginTransaction();
			session.save(retiroMedicamento);
	        tx1.commit();
	        session.close();
	        return true;
	        
		}catch(Exception e){
			e.printStackTrace();
		}
        return false;
	}
	
	public static boolean updateRetiroMedicamento(HttpServletRequest request, Integer id, ObjectNode message){
	
		Retiro_medicamento retiroMedicamento = getRetiroMedicamento(id);
		setRetiroMedicamento(request, retiroMedicamento);
		try{
			SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
			Session session = sessionFactory.openSession(); 
			Transaction tx1 = session.beginTransaction();
			session.update(retiroMedicamento);
	        tx1.commit();
	        session.close();
	        return true;
	        
		}catch(Exception e){
			e.printStackTrace();
			message.put("message", "Hubo un problema en el servidor");
			return false;
		}
	}
	
	public static Retiro_medicamento fillRetiroMedicamento(HttpServletRequest request){

		String nombre = Utils.getStringUTF(request.getParameter("nombre"));
		String lugar = Utils.getStringUTF(request.getParameter("lugar"));
		String dosis = Utils.getStringUTF(request.getParameter("dosis"));

		String hora = request.getParameter("hora");
		Date fecha = Utils.stringToDate(request.getParameter("fecha"), "yyyy-MM-dd");
		String paciente_rut = request.getParameter("paciente_rut");
		String id_institucion = request.getParameter("id_institucion");
		Paciente paciente = PacienteService.getPaciente(paciente_rut);
		Institucion institucion = InstitucionService.getInstitucion(id_institucion);
		Retiro_medicamento retiroMedicamento = new Retiro_medicamento();
		retiroMedicamento.setNombre(nombre);
		retiroMedicamento.setHora(hora);
		retiroMedicamento.setFecha(fecha);
		retiroMedicamento.setLugar(lugar);
		retiroMedicamento.setPaciente(paciente);
		retiroMedicamento.setInstitucion(institucion);
		retiroMedicamento.setDosis(dosis);
		
		return retiroMedicamento;
	}
	
	private static void setRetiroMedicamento(HttpServletRequest request, Retiro_medicamento retiroMedicamento){
		
		String nombre = Utils.getStringUTF(request.getParameter("nombre"));
		String lugar = Utils.getStringUTF(request.getParameter("lugar"));
		String dosis =Utils. getStringUTF(request.getParameter("dosis"));
		
		String hora = request.getParameter("hora");
		Date fecha = Utils.stringToDate(request.getParameter("fecha"), "yyyy-MM-dd");
		 
		String paciente_rut = request.getParameter("paciente_rut");
		String id_institucion = request.getParameter("id_institucion");
		
		Paciente paciente = PacienteService.getPaciente(paciente_rut);
		Institucion institucion = InstitucionService.getInstitucion(id_institucion);
		retiroMedicamento.setNombre(nombre);
		retiroMedicamento.setHora(hora);
		retiroMedicamento.setFecha(fecha);
		retiroMedicamento.setLugar(lugar);
		retiroMedicamento.setPaciente(paciente);
		retiroMedicamento.setInstitucion(institucion);
		retiroMedicamento.setDosis(dosis);
	}
	
	private static List<Retiro_medicamento> getObjects(String query){
		try {
			SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
	        Session session = sessionFactory.openSession();
	        Query q = session.createQuery(query);
	        List<Retiro_medicamento> retiroMedicamentos =  q.list();	 
	        return retiroMedicamentos;
		}catch(HibernateException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean deleteRetiroMedicamento(Integer id){
		try{
			SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
	        Session session = sessionFactory.openSession();
	        Transaction tx1 = session.beginTransaction();
	        Retiro_medicamento retiroMedicamento = getRetiroMedicamento(id);
			session.delete(retiroMedicamento);
	        tx1.commit();
	        return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}		
	}
	
	private static Retiro_medicamento getRetiroMedicamento(Integer id){
			SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
	        Session session = sessionFactory.openSession();
	        Query q = session.createQuery("from Retiro_medicamento r where r.id='" + id + "'");
	        Retiro_medicamento retiroMedicamento =  (Retiro_medicamento) q.uniqueResult();	 
	        return retiroMedicamento;
	}
	
	
	

}
