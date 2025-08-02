package frgp.utn.edu.ar.daoImp;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import frgp.utn.edu.ar.dao.DaoEspecialidad;

import frgp.utn.edu.ar.entidad.Especialidad;

public class DaoEspecialidadImpl implements DaoEspecialidad{
	
	
	//**** PARA SPRING MVC
	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
	//**** PARA SPRING MVC
	
	@Override
	public void AddEspecialidad(Especialidad especialidad) {
//		Session session = config.abrirConexion();
//		Transaction transaction = null;
//		try {
//			transaction = session.beginTransaction();
//			session.save(especialidad);
//			transaction.commit();
//		} catch (Exception e) {
//			if(transaction != null && transaction.isActive()) {
//				transaction.rollback();
//			}
//			e.printStackTrace();
//		}
//		finally {
//			config.cerrarSession();
//		}
	}

	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertarEspecialidad(Especialidad especialidad) {
		this.hibernateTemplate.save(especialidad);
		
	}
}
