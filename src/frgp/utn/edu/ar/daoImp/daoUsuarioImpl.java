package frgp.utn.edu.ar.daoImp;

import org.hibernate.Session;
import org.hibernate.Transaction;

import frgp.utn.edu.ar.dao.daoUsuario;
import frgp.utn.edu.ar.entidad.Usuario;

public class daoUsuarioImpl implements daoUsuario {
    
    private ConfigHibernate config;
    
    public void setConfig(ConfigHibernate config) {
        this.config = config;
    }
    
    @Override
    public void AddUsuario(Usuario usuario) {
        Session session = config.abrirConexion();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(usuario);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            config.cerrarSession();
        }
    }
} 