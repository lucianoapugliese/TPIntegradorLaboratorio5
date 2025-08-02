package frgp.utn.edu.ar.servicioImpl;

import java.util.ArrayList;
import java.util.List;

import frgp.utn.edu.ar.dao.MedicoDao;
import frgp.utn.edu.ar.dominio.Medico;
import frgp.utn.edu.ar.servicio.MedicoServicio;

public class MedicoServicioImpl implements MedicoServicio {
	
	private MedicoDao dataAccess;
	
    // SETTER PARA LA INYECCION
	public void setDataAccess(MedicoDao dataAccess) {
		this.dataAccess = dataAccess;
	}

//	@Override
//	public void insertarPaciente(Paciente paciente) {
//		dataAccess.insertarPaciente(paciente);
//		
//	}

	@Override
	public ArrayList<Medico> obtenerMedicos() {
		return dataAccess.obtenerMedicos();
	}

	@Override
	public void Delete(Medico m) {
		this.dataAccess.Delete(m);
	}

	@Override
	public Medico ReadOne(int legajo) {
		Medico medico = dataAccess.ReadOne(legajo);
		return medico;
	}

	@Override
	public List<Medico> medicosActivos() {
		return dataAccess.medicosActivos();
	}

	@Override
	public Boolean addMedico(Medico medico) {
		dataAccess.addMedico(medico);
		return true;
	}

	@Override
	public Medico ReadOne(Integer legajo) {
		Medico medico = dataAccess.ReadOne(legajo);
		return medico;
	}


	@Override
	public void update(Medico medico) {
	    dataAccess.updateMedico(medico);
	}



}
