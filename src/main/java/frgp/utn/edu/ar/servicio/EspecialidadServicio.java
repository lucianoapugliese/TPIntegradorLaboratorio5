package frgp.utn.edu.ar.servicio;

import java.util.ArrayList;

import frgp.utn.edu.ar.dominio.Especialidad;

public interface EspecialidadServicio {
	
	void insertarEspecialidad(Especialidad especialidad);
	
	ArrayList<Especialidad> obtenerEspecialidades();
	
	public Especialidad getEspecialidadById(int id);
	
}