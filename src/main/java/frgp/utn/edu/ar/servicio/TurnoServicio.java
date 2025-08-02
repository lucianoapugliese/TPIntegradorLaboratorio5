package frgp.utn.edu.ar.servicio;

import java.util.ArrayList;

import frgp.utn.edu.ar.dominio.Turno;

public interface TurnoServicio {
void insertarTurno(Turno turno);
	
	ArrayList<Turno> obtenerTurnos();
	
	public Turno getTurnoById(int id);

	void update(Turno turno);

	Turno getTurnoById(long id);

	ArrayList<Turno> obtenerTurnosPorMedico(String legajo);
}
