package frgp.utn.edu.ar.servicio;

import java.util.ArrayList;
import java.util.List;

import frgp.utn.edu.ar.dominio.Medico;

public interface MedicoServicio {
	
	//void insertarPaciente(Paciente paciente);
	
	ArrayList<Medico> obtenerMedicos();

	public void Delete(Medico m);
	public Medico ReadOne(int legajo);
	public Medico ReadOne(Integer legajo);
	public List<Medico> medicosActivos();
	public Boolean addMedico(Medico medico);

	void update(Medico medico);
	
}