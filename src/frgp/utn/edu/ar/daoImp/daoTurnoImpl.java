package frgp.utn.edu.ar.daoImp;

import org.hibernate.Session;
import org.hibernate.Transaction;

import frgp.utn.edu.ar.dao.daoTurno;
import frgp.utn.edu.ar.entidad.Turno;

public class daoTurnoImpl implements daoTurno {
    
    private ConfigHibernate config;
    
    public void setConfig(ConfigHibernate config) {
        this.config = config;
    }
    
    @Override
    public void AddTurno(Turno turno) {
        Session session = config.abrirConexion();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(turno);
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