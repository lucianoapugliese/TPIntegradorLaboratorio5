package frgp.utn.edu.ar.controller;

import javax.servlet.ServletConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.entidad.Especialidad;
import frgp.utn.edu.ar.negocio.NegocioEspecialidad;
import frgp.utn.edu.ar.negocio.NegocioMedico;


/// IMPORTANTE NO OLVIDAR ESTA ANOTACION
@Controller
public class PaginaController {


	@Autowired
	public NegocioMedico service;
	
	@Autowired
	public  NegocioEspecialidad negocioEspecialidad;
	
	
	
	
	

	public void init(ServletConfig config) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());

		this.service = (NegocioMedico) ctx.getBean("serviceBean");
	}

	// Inicio

	@RequestMapping("index.html")
	public ModelAndView redireccion() {
		ModelAndView MV = new ModelAndView();

		// MV.addObject("listaMedicos",this.service.obtenerMedicos());

		MV.setViewName("Especialidades_agregar");
		return MV;
	}

	/// ESPECIALIDADES
	@RequestMapping(value = "/altaEspecialidad.html", method = { RequestMethod.GET, RequestMethod.POST })
	public void validarUsuario(String nombreEspecialidad) {
		ModelAndView MV = new ModelAndView();

		System.out.println("Especialidad: " + nombreEspecialidad);

		Especialidad especialidad = new Especialidad();
		especialidad.setNombre(nombreEspecialidad);
		String Message="";

		try {

			negocioEspecialidad.insertarEspecialidad(especialidad);
			Message = "Usuario agregado";
		} catch (Exception e) {
			Message = "No se pudo insertar el usuario";
		} finally {

		}

		// Usuario x = new Usuario();
		// x.setNombreU(nombreU);
		// x.setPassU(passU);
		//
		// String Message="";
		//
		// try{
		//
		// service.insertarUsuario(x);
		// Message = "Usuario agregado";
		// }
		// catch(Exception e)
		// {
		// Message = "No se pudo insertar el usuario";
		// }
		// finally
		// {
		//
		// }
		//
		// MV.setViewName("Usuarios");
		// MV.addObject("Mensaje", Message);
		// MV.addObject("listaUsuarios",this.service.obtenerUsuarios());
		// MV.setViewName("Usuarios");
		// return MV;

	}
}
