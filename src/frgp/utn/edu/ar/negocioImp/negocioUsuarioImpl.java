package frgp.utn.edu.ar.negocioImp;

import frgp.utn.edu.ar.daoImp.daoUsuarioImpl;
import frgp.utn.edu.ar.entidad.Usuario;
import frgp.utn.edu.ar.negocio.negocioUsuario;

public class negocioUsuarioImpl implements negocioUsuario {
    
    private daoUsuarioImpl dao;
    
    public void setDao(daoUsuarioImpl dao) {
        this.dao = dao;
    }
    
    @Override
    public void AddUsuario(Usuario usuario) {
        dao.AddUsuario(usuario);
    }
} 