package frgp.utn.edu.ar.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import frgp.utn.edu.ar.dao.UsuarioDao;
import frgp.utn.edu.ar.dominio.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

//	@Override
//	@Transactional(propagation=Propagation.REQUIRED)
//	public void insertarUsuario(Usuario usuario) {
//		this.hibernateTemplate.save(usuario);
//		
//	}
//
//	@Override
//	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
//	public Usuario obtenerUsuarioPorNombre(String nombreUser) {
//		return this.hibernateTemplate.get(Usuario.class, nombreUser);
//	}
//
//	@Override
//	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
//	public ArrayList<Usuario> obtenerUsuarios() {
//		return (ArrayList<Usuario>) this.hibernateTemplate.loadAll(Usuario.class);
//	}
//
//	
//	@Override
//	@Transactional(propagation=Propagation.REQUIRES_NEW)
//	public void eliminarUsuario(Integer idUsuario) {
//		Usuario user = new Usuario();
//		user.setId(idUsuario);
//		this.hibernateTemplate.delete(user);
//	}
//
//	@Override
//	@Transactional(propagation=Propagation.REQUIRED)
//	public void actualizarUsuario(Usuario persona) {
//		this.hibernateTemplate.update(persona);
//	}

	@Override
	public Usuario validarUsuario(Usuario usuario) {
		
		System.out.println("LLEGUE USUARIO DAO IMPL");
	    String hql = "FROM Usuario u WHERE u.nombreUsuario = :nombre AND u.password = :password";
	    @SuppressWarnings("unchecked")
		List<Usuario> resultados = (List<Usuario>) hibernateTemplate.findByNamedParam(
	        hql,
	        new String[] { "nombre", "password" },
	        new Object[] { usuario.getNombreUsuario(), usuario.getPassword() }
	    );

	    if (resultados != null && !resultados.isEmpty()) {
			System.out.println("LLEGUE USUARIO DAO IMPL 2");
	        return resultados.get(0); // Usuario encontrado
	    }
		System.out.println("LLEGUE USUARIO DAO IMPL 3");
	    return null; // No se encontró usuario
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Usuario obtenerUsuarioPorNombre(String nombreUser) {
		return this.hibernateTemplate.get(Usuario.class, nombreUser);
	}


}
