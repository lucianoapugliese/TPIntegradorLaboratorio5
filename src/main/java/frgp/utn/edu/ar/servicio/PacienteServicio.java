package frgp.utn.edu.ar.servicio;

import java.util.ArrayList;

import frgp.utn.edu.ar.dominio.Paciente;

public interface PacienteServicio {
	
	void insertarPaciente(Paciente paciente);
	
	ArrayList<Paciente> obtenerPacientes();
	
	public Paciente ReadOne(String dni);

	void Delete(Paciente p);

	void Update(Paciente p);
}