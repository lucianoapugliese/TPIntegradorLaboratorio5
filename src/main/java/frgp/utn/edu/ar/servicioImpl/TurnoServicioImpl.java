package frgp.utn.edu.ar.servicioImpl;

import java.util.ArrayList;

import frgp.utn.edu.ar.dao.TurnoDao;
import frgp.utn.edu.ar.dominio.Turno;
import frgp.utn.edu.ar.servicio.TurnoServicio;

public class TurnoServicioImpl implements TurnoServicio {
	private TurnoDao dataAccess;

	public void setDataAccess(TurnoDao dataAccess) {
		this.dataAccess = dataAccess;
	}

	@Override
	public void insertarTurno(Turno turno) {
		dataAccess.insertarTurno(turno);
		
	}
	
	@Override
	public ArrayList<Turno> obtenerTurnos() {
		return dataAccess.obtenerTurnos();
	}
	
	@Override
	public ArrayList<Turno> obtenerTurnosPorMedico(String legajo) {
		return dataAccess.obtenerTurnosPorMedico(legajo);
	}

	@Override
	public Turno getTurnoById(long id) {
		return dataAccess.getTurnoById(id);
	}
	
	@Override
	public void update(Turno turno) {
		dataAccess.update(turno);
	}

	@Override
	public Turno getTurnoById(int id) {
		return dataAccess.getTurnoById(id);
	}

}
