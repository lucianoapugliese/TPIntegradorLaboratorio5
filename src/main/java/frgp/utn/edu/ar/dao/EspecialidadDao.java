package frgp.utn.edu.ar.dao;

import java.util.ArrayList;

import frgp.utn.edu.ar.dominio.Especialidad;

public interface EspecialidadDao {
	
	//ALTA ESPECIALIDAD
	void insertarEspecialidad(Especialidad especialidad);
	
	//OBTIENE TODAS LAS ESPECIALIDADES
	ArrayList<Especialidad> obtenerEspecialidades();
	
	public Especialidad getEspecialidadById(int id);
}