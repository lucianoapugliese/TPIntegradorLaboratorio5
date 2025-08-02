package frgp.utn.edu.ar.dao;

import java.util.ArrayList;

import frgp.utn.edu.ar.entidad.Medico;

public interface daoMedico {

	public void AddMedico(Medico medico);
	
	/// LISTAR TODOS LOS MEDICOS
	public ArrayList<Medico> obtenerMedicos();
}
