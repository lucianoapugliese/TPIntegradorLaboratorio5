package frgp.utn.edu.ar.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Convert;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.exception.spi.ConversionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;


import org.springframework.web.bind.annotation.PathVariable;

import frgp.utn.edu.ar.dominio.Usuario;
import frgp.utn.edu.ar.servicio.UsuarioServicio;

@Controller
public class UserController {

	@Autowired
	public UsuarioServicio usuarioService;

	public void initLogin(ServletConfig config) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());

		this.usuarioService = (UsuarioServicio) ctx.getBean("LoginsServiceBean");
	}
	
	// **************** INICIO ****************

	@RequestMapping("index.html")
	public ModelAndView redireccion() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Login");
		return MV;
	}
	// **************** LOGIN ****************
	@RequestMapping(value ="/login.html" , method= { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView validarLogin(String username, String password, HttpServletResponse response, HttpSession session){
		ModelAndView MV = new ModelAndView();
		
		System.out.println("USUARIO: " + username);
		System.out.println("CONTRASEÑA: " + password);
		
		Usuario usuario = new Usuario();
		usuario.setNombreUsuario(username);
		usuario.setPassword(password);
		
		String Message="";
		
		try{
			
			usuario = usuarioService.validarUsuario(usuario);
			System.out.println("ROL: " + usuario.getRol());
			
			if(usuario!= null && usuario.getRol().equals("ADMINISTRADOR")) {
				session.setAttribute("rolUsuario", usuario.getRol());
				session.setAttribute("contraseniaUsuario", usuario.getPassword());
				session.setAttribute("nombreUsuario", usuario.getNombreUsuario());
				
				
				
				/// OBTENGO LOS MEDICOS, PACIENTES, ESPECIALIDADES
//				MV.addObject("listaPacientes", this.Pacienteservice.obtenerPacientes());
//				MV.addObject("listaMedicos", this.MedicoServicio.obtenerMedicos());
//				MV.addObject("listaEspecialidades", this.service.obtenerEspecialidades());
				
				
				MV.setViewName("HomeAdmin");
				
				
				
				
				
				
				return MV;
			}
			if(usuario!= null && usuario.getRol().equals("medico")) {
				//session.setAttribute("usuarioActual", usuario);
				session.setAttribute("rolUsuario", usuario.getRol());
				session.setAttribute("contraseniaUsuario", usuario.getPassword());
				session.setAttribute("nombreUsuario", usuario.getNombreUsuario());
				session.setAttribute("legajo", usuarioService.obtenerUnRegistro(usuario.getNombreUsuario()).getMedico().getLegajo());
				MV.setViewName("HomeMedico");
				return MV;
			}
		}
		catch(Exception e)
		{
			/// FALTA COMPLETAR
		}
		finally
		{
			/// FALTA COMPLETAR
		}
	
		MV.setViewName("Login");
		return MV;
		
	}
	
	/// ***** CLIC SOBRE SISTEMA DE GESTION MEDICA *****
	@RequestMapping(value = "/irHomeAdmin.html", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView irHomeAdmin() {
		
		System.out.println("no soy de aqui");
		
		ModelAndView MV = new ModelAndView();
		
		MV.setViewName("HomeAdmin");
				
		return MV;

	}
	
	@RequestMapping(value = "/irHomeMedico.html", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView irHomeMedico() {
		
		System.out.println("no soy de aqui");
		
		ModelAndView MV = new ModelAndView();
		
		MV.setViewName("HomeMedico");
		
		return MV;
		
	}
	
}
