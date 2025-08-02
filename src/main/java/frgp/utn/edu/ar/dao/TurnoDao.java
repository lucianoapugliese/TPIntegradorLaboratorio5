package frgp.utn.edu.ar.dao;

import java.util.ArrayList;

import frgp.utn.edu.ar.dominio.Paciente;
import frgp.utn.edu.ar.dominio.Turno;

public interface TurnoDao {
	
	void insertarTurno(Turno turno);
	
	ArrayList<Turno> obtenerTurnos();
	
	public Turno getTurnoById(long id);

	void update(Turno turno);

	public ArrayList<Turno> obtenerTurnosPorMedico(String legajo);

}
