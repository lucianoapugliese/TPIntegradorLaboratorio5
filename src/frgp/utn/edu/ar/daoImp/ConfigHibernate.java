package frgp.utn.edu.ar.daoImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConfigHibernate {
	
	private SessionFactory sessionFactory;
	private Session session;
	private Configuration configuration;
	
	public ConfigHibernate() 
	{
		configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
	}
	
	public Session abrirConexion()
	{
		session = sessionFactory.openSession();
		return session;
	}
	
	public void cerrarSession()
	{
		if (session != null && session.isOpen()) {
			session.close();
		}
	}
	
	public void cerrarSessionFactory()
	{
		if (sessionFactory != null && !sessionFactory.isClosed()) {
			sessionFactory.close();
		}
	}
}