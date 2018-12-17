package cl.miHospital.Service;

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
}
