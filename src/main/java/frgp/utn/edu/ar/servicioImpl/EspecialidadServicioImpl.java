package frgp.utn.edu.ar.servicioImpl;

import java.util.ArrayList;

import frgp.utn.edu.ar.dao.EspecialidadDao;
import frgp.utn.edu.ar.dominio.Especialidad;
import frgp.utn.edu.ar.servicio.EspecialidadServicio;

public class EspecialidadServicioImpl implements EspecialidadServicio {

	private EspecialidadDao dataAccess; // Usa la interfaz, no la implementación

    // SETTER PARA LA INYECCION
	public void setDataAccess(EspecialidadDao dataAccess) {
		this.dataAccess = dataAccess;
	}

	@Override
	public void insertarEspecialidad(Especialidad especialidad) {
		dataAccess.insertarEspecialidad(especialidad);
		
	}
	
	@Override
	public ArrayList<Especialidad> obtenerEspecialidades() {
		return dataAccess.obtenerEspecialidades();
	}

	@Override
	public Especialidad getEspecialidadById(int id) {
		return dataAccess.getEspecialidadById(id);
	}
	
}
