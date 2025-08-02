package frgp.utn.edu.ar.daoImpl;


import java.util.ArrayList;
import java.util.List;

import javax.management.Query;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import frgp.utn.edu.ar.dao.MedicoDao;
import frgp.utn.edu.ar.dao.PacienteDao;
import frgp.utn.edu.ar.dominio.Medico;
import frgp.utn.edu.ar.dominio.Paciente;


public class MedicoDaoImpl implements MedicoDao{
	
	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

//	@Override
//	@Transactional(propagation=Propagation.REQUIRED)
//	public void insertarMedico(Paciente paciente) {
//		this.hibernateTemplate.save(paciente);		
//	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public ArrayList<Medico> obtenerMedicos() {
		return (ArrayList<Medico>) this.hibernateTemplate.loadAll(Medico.class);
	}

	

	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Medico ReadOne(int legajo) {
		 return (Medico) hibernateTemplate.execute(session -> 
	        session.createQuery("FROM Medico WHERE legajo = :legajo")
	              .setParameter("legajo", legajo)
	              .uniqueResult()
	    );

	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void Delete(Medico m) {
		this.hibernateTemplate.update(m);
		return ;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional( readOnly = true)
	public List<Medico> medicosActivos() {
		String query = "FROM Medico WHERE estado = true";
	    return (List<Medico>) hibernateTemplate.find(query);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean addMedico(Medico medico) {
		try {
			this.hibernateTemplate.save(medico);
			return true;
		} catch (Exception e) {
			System.out.println("El medico no pudo ser agregado");
		}
		return false;
	}

	@Override
	public Medico ReadOne(Integer legajo) {
				 return (Medico) hibernateTemplate.execute(session -> 
	        session.createQuery("FROM Medico WHERE legajo = :legajo")
	              .setParameter("legajo", legajo)
	              .uniqueResult()
	    );

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateMedico(Medico medico) {
	    this.hibernateTemplate.update(medico);
	}
	

}
