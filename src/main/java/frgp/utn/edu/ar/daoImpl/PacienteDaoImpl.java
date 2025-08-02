package frgp.utn.edu.ar.daoImpl;


import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import frgp.utn.edu.ar.dao.PacienteDao;
import frgp.utn.edu.ar.dominio.Medico;
import frgp.utn.edu.ar.dominio.Paciente;


public class PacienteDaoImpl implements PacienteDao{
	
	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertarPaciente(Paciente paciente) {
		this.hibernateTemplate.save(paciente);		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public ArrayList<Paciente> obtenerPacientes() {
	    return hibernateTemplate.execute(session -> 
	        new ArrayList<>(session.createQuery("FROM Paciente WHERE estado = 1").list())
	    );
	}

	@Override
	public Paciente ReadOne(String dni) {
		return (Paciente) hibernateTemplate.execute(session -> 
        session.createQuery("FROM Paciente WHERE dni = :dni")
              .setParameter("dni", dni)
              .uniqueResult()
    );
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void Delete(Paciente p) {
		this.hibernateTemplate.update(p);
		return ;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updatePaciente(Paciente paciente) {
	    this.hibernateTemplate.update(paciente);
	}
}
