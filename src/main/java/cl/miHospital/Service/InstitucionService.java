package cl.miHospital.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cl.miHospital.model.Institucion;
import cl.miHospital.util.HibernateUtility;

public class InstitucionService {
	
	public static Institucion getInstitucion(String id){
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query q = session.createQuery("from Institucion i where i.id_institucion='" + id + "'");
        Institucion institucion =  (Institucion) q.uniqueResult();	 
        return institucion;
	}
	
	public static List<Institucion> getInstituciones(){
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query q = session.createQuery("from Institucion");
        List<Institucion> instituciones =   q.list();	 
        return instituciones;
	}
}
