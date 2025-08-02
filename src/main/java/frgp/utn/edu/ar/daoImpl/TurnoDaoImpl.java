package frgp.utn.edu.ar.daoImpl;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import frgp.utn.edu.ar.dao.TurnoDao;
import frgp.utn.edu.ar.dominio.Turno;

public class TurnoDaoImpl implements TurnoDao{
	
	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertarTurno(Turno turno) {
		this.hibernateTemplate.save(turno);
		
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Turno> obtenerTurnos() {
		return (ArrayList<Turno>) this.hibernateTemplate.loadAll(Turno.class);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Turno> obtenerTurnosPorMedico(String legajo) {
		return (ArrayList<Turno>) hibernateTemplate.find("FROM Turno WHERE medico_id = " + legajo);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void update(Turno turno) {
		this.hibernateTemplate.update(turno);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Turno getTurnoById(long id) {
		return (Turno) hibernateTemplate.execute(session -> 
        session.createQuery("FROM Turno WHERE id = :id")
              .setParameter("id", id)
              .uniqueResult()
    );
	}
	


}
