package frgp.utn.edu.ar.daoImp;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import frgp.utn.edu.ar.dao.daoMedico;
import frgp.utn.edu.ar.entidad.Medico;

public class daoMedicoImpl implements daoMedico {
	
	private ConfigHibernate config;

	// ESTO ES INYECTADO POR SPRING
	public void setConfig(ConfigHibernate config) {
		this.config = config;
	}
	
	
	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

	@Override
	public void AddMedico(Medico medico) {
		// TODO Auto-generated method stub											COMPLETAR
		
	}

	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public ArrayList<Medico> obtenerMedicos() {
		return (ArrayList<Medico>) this.hibernateTemplate.loadAll(Medico.class);
	}

}
