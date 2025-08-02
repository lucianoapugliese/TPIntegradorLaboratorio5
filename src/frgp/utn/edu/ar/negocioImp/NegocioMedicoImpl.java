package frgp.utn.edu.ar.negocioImp;

import java.util.ArrayList;

import frgp.utn.edu.ar.dao.daoMedico;
import frgp.utn.edu.ar.daoImp.daoMedicoImpl;
import frgp.utn.edu.ar.entidad.Medico;
import frgp.utn.edu.ar.negocio.NegocioMedico;

public class NegocioMedicoImpl implements NegocioMedico{
	
    private daoMedicoImpl dao; // Debe coincidir con el tipo del bean que se inyectará
    

	
	public void setDao(daoMedicoImpl dao) {
		this.dao = dao;
	}

	
	private daoMedico dataAccess = null;

//	public void setDataAccess(daoMedico dataAccess) {
//		this.dataAccess = dataAccess;
//	}

//	@Override
//	public void addMedico(Medico medico) {
//		dataAccess.AddMedico(medico);
//		
//	}
	
	@Override
	public void addMedico(Medico medico) {
		dao.AddMedico(medico);
		
	}

	@Override
	public ArrayList<Medico> obtenerMedicos() {
		return dataAccess.obtenerMedicos();
	}

}
