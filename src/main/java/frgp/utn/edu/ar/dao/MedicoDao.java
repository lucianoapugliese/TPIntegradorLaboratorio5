package frgp.utn.edu.ar.dao;

import java.util.ArrayList;
import java.util.List;

import frgp.utn.edu.ar.dominio.Medico;

public interface MedicoDao {
	
//	//ALTA MEDICO
//	void insertarPaciente(Paciente paciente);
	
	//OBTIENE TODAS LOS MEDICOS
	ArrayList<Medico> obtenerMedicos();
	
	public void Delete(Medico m);
	public Medico ReadOne(int legajo);
	public Medico ReadOne(Integer legajo);
	public List<Medico> medicosActivos();
	public boolean addMedico(Medico medico);

	void updateMedico(Medico medico);


}