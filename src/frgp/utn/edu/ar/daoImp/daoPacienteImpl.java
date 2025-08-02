package frgp.utn.edu.ar.daoImp;

import org.hibernate.Session;
import org.hibernate.Transaction;

import frgp.utn.edu.ar.dao.daoPaciente;
import frgp.utn.edu.ar.entidad.Paciente;

public class daoPacienteImpl implements daoPaciente {
	
	private ConfigHibernate config;

	// ESTO ES INYECTADO POR SPRING
	public void setConfig(ConfigHibernate config) {
		this.config = config;
	}

	@Override
	public void AddPaciente(Paciente paciente) {
		Session session = config.abrirConexion();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(paciente);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			config.cerrarSession();
		}
	}

}
