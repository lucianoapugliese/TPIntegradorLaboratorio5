package frgp.utn.edu.ar.daoImpl;


import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import frgp.utn.edu.ar.dao.EspecialidadDao;
import frgp.utn.edu.ar.dao.MedicoDao;
import frgp.utn.edu.ar.dominio.Especialidad;
import frgp.utn.edu.ar.dominio.Medico;
import frgp.utn.edu.ar.dominio.Usuario;

public class EspecialidadDaoImpl implements EspecialidadDao{
	
	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertarEspecialidad(Especialidad especialidad) {
		this.hibernateTemplate.save(especialidad);
		
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Especialidad> obtenerEspecialidades() {
		return (ArrayList<Especialidad>) this.hibernateTemplate.loadAll(Especialidad.class);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Especialidad getEspecialidadById(int id) {
		return (Especialidad) hibernateTemplate.execute(session -> 
        session.createQuery("FROM Especialidad WHERE id = :id")
              .setParameter("id", id)
              .uniqueResult()
    );
	}
}
