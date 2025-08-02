package frgp.utn.edu.ar.dao;

import java.util.ArrayList;

import frgp.utn.edu.ar.dominio.Paciente;


public interface PacienteDao {
	
	
	void insertarPaciente(Paciente paciente);
	
	ArrayList<Paciente> obtenerPacientes();
	
	public Paciente ReadOne(String dni);

	void Delete(Paciente p);

	void updatePaciente(Paciente paciente);
}