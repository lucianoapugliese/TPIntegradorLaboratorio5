package frgp.utn.edu.ar.negocioImp;

import frgp.utn.edu.ar.dao.DaoEspecialidad;

import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.negocio.NegocioEspecialidad;

public class NegocioEspecialidadImpl implements NegocioEspecialidad {
	
	
	//**** PARA SPRING MVC
	private DaoEspecialidad dao = null;

	public void setDAO(DaoEspecialidad dao) {
		this.dao = dao;
	}
	
	@Override
	public void AddEspecialidad(Especialidad especialidad) {
		dao.AddEspecialidad(especialidad);
	}
	//**** PARA SPRING MVC
	
	
	@Override
	public void insertarEspecialidad(Especialidad especialidad) {
		 dao.insertarEspecialidad(especialidad);
		
	}
	
}
