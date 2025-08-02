package frgp.utn.edu.ar.negocioImp;

import frgp.utn.edu.ar.daoImp.daoPacienteImpl;
import frgp.utn.edu.ar.entidad.Paciente;
import frgp.utn.edu.ar.negocio.negocioPaciente;


public class negocioPacienteImpl implements negocioPaciente{
	
	private daoPacienteImpl dao;

	public void setDao(daoPacienteImpl dao) {
		this.dao = dao;
	}

	@Override
	public void AddPaciente(Paciente paciente) {
		dao.AddPaciente(paciente);
	}

}

