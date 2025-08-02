package frgp.utn.edu.ar.servicioImpl;

import java.util.ArrayList;

import frgp.utn.edu.ar.dao.PacienteDao;
import frgp.utn.edu.ar.dominio.Medico;
import frgp.utn.edu.ar.dominio.Paciente;
import frgp.utn.edu.ar.servicio.PacienteServicio;

public class PacienteServicioImpl implements PacienteServicio {
	
	private PacienteDao dataAccess;
	
	public void setDataAccess(PacienteDao dataAccess) {
		this.dataAccess = dataAccess;
	}

	@Override
	public void insertarPaciente(Paciente paciente) {
		dataAccess.insertarPaciente(paciente);
		
	}

	@Override
	public ArrayList<Paciente> obtenerPacientes() {
		return dataAccess.obtenerPacientes();
	}

	@Override
	public Paciente ReadOne(String dni) {
		Paciente paciente = dataAccess.ReadOne(dni);
		return paciente;
	}
	
	@Override
	public void Delete(Paciente p) {
		this.dataAccess.Delete(p);
	}
	
	
	@Override
	public void Update(Paciente p) {
		this.dataAccess.updatePaciente(p);
	}
		
}
