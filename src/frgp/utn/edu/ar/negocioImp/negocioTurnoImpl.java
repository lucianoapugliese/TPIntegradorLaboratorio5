package frgp.utn.edu.ar.negocioImp;

import frgp.utn.edu.ar.daoImp.daoTurnoImpl;
import frgp.utn.edu.ar.entidad.Turno;
import frgp.utn.edu.ar.negocio.negocioTurno;

public class negocioTurnoImpl implements negocioTurno {
    
    private daoTurnoImpl dao;
    
    public void setDao(daoTurnoImpl dao) {
        this.dao = dao;
    }
    
    @Override
    public void AddTurno(Turno turno) {
        dao.AddTurno(turno);
    }
} 