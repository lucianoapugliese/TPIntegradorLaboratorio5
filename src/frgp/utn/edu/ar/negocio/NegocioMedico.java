package frgp.utn.edu.ar.negocio;

import java.util.ArrayList;

import frgp.utn.edu.ar.entidad.Medico;

public interface NegocioMedico {
	public void addMedico(Medico medico);
	ArrayList<Medico> obtenerMedicos();
}
