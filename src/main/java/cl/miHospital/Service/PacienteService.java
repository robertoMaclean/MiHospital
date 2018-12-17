package cl.miHospital.Service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cl.miHospital.model.Paciente;
import cl.miHospital.util.HibernateUtility;

public class PacienteService {
	
	public static Paciente getPaciente(String rut){
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query q = session.createQuery("from Paciente p where p.rut='" + rut + "'");
        Paciente paciente =  (Paciente) q.uniqueResult();	 
        return paciente;
	}
}
