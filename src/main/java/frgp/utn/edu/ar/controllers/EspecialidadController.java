package frgp.utn.edu.ar.controllers;

import java.text.SimpleDateFormat;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import frgp.utn.edu.ar.dominio.Especialidad;
import frgp.utn.edu.ar.dominio.Medico;
import frgp.utn.edu.ar.dominio.Paciente;
import frgp.utn.edu.ar.dominio.Usuario;
import frgp.utn.edu.ar.servicio.EspecialidadServicio;
import frgp.utn.edu.ar.servicio.PacienteServicio;
import frgp.utn.edu.ar.servicio.UsuarioServicio;
import frgp.utn.edu.ar.servicio.MedicoServicio;

@Controller
public class EspecialidadController {
	
/*	
	@Autowired
	public UsuarioServicio LoginService;

	public void initLogin(ServletConfig config) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());

		this.LoginService = (UsuarioServicio) ctx.getBean("LoginsServiceBean");
	}
	
	*/

	@Autowired
	public EspecialidadServicio service;

	public void init(ServletConfig config) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());

		this.service = (EspecialidadServicio) ctx.getBean("serviceBean");
	}
	
	@Autowired
	public PacienteServicio Pacienteservice;

	public void initPaciente(ServletConfig config) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());

		this.Pacienteservice = (PacienteServicio) ctx.getBean("pacienteServiceBean");
	}

	
	@Autowired
	public MedicoServicio MedicoServicio;

	public void initMedico(ServletConfig config) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());

		this.MedicoServicio = (MedicoServicio) ctx.getBean("medicoServiceBean");
	}
	
	/*
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
			
			usuario = LoginService.validarUsuario(usuario);
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
			if(usuario!= null && usuario.getRol().equals("MEDICO")) {
				session.setAttribute("usuarioActual", usuario);
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
	*/
	// **************** MEDICOS ****************
//
//	@RequestMapping(value = "/altaMedico.html", method = { RequestMethod.GET, RequestMethod.POST })
//	public ModelAndView altaMedico() {
//		
//		
//		ModelAndView MV = new ModelAndView();
//		
//		MV.addObject("especialidades", this.service.obtenerEspecialidades());
//		
//		MV.setViewName("Medicos_agregar");
//		return MV;
//
//
//	}
//	
//	
//	
//	@RequestMapping(value = "/listarMedicos.html", method = { RequestMethod.GET, RequestMethod.POST })
//	public ModelAndView listarMedicos() {
//		ModelAndView MV = new ModelAndView();
//
//		System.out.println("LISTA DE MEDICOS");
//
//		MV.addObject("listaMedicos", this.MedicoServicio.obtenerMedicos());
//		MV.setViewName("Medicos_listar");
//		return MV;
//
//	}
//		
//	@RequestMapping(value = "/bajaMedico.html", method = { RequestMethod.GET, RequestMethod.POST})
//	public ModelAndView deleteDoctor(@RequestParam("legajo") Integer legajo, Model model ){
//		
//		ModelAndView MV = new ModelAndView();
//		
//		System.out.println(legajo);
//		
//		try {
//			Medico m = MedicoServicio.ReadOne(legajo);
//			System.out.println(m.getApellido().toString());
//			m.setEstado(false);
//			MedicoServicio.Delete(m);
//			System.out.println("El medico fue dado de baja correctamente");
//			MV.setViewName("redirect:/listarMedicosActivos.html");
//		} catch (Exception e) {
//			System.out.println("El medico no ha podido ser dado de baja");
//		}
//		
//		MV.setViewName("redirect:/listarMedicosActivos.html");
//		return MV;
//		
//	}
//	
//	@RequestMapping(value = "/listarMedicosActivos.html", method = { RequestMethod.GET, RequestMethod.POST })
//	public ModelAndView listarMedicosActivos() {
//		ModelAndView MV = new ModelAndView();
//
//		System.out.println("LISTA DE MEDICOS ACTIVOS");
//
//		MV.addObject("listaMedicos", this.MedicoServicio.medicosActivos());
//		MV.setViewName("Medicos_listar");
//		return MV;
//
//	}
//	
//	@RequestMapping(value = "/guardarMedico.html", method = { RequestMethod.GET, RequestMethod.POST })
//	public ModelAndView altaMedico(Integer legajo, String nombre, String apellido, String sexo, 
//			String fechaNacimiento, String direccion, String localidad, 
//			String email, String telefono, String diasTrabajo, 
//			String horarioTrabajo, Boolean estado, Integer especialidad) {
//		
//		ModelAndView MV = new ModelAndView();
//		Medico medico = new Medico();
//		
//		medico.setLegajo(legajo);
//		medico.setNombre(nombre);
//		medico.setApellido(apellido);
//		medico.setSexo(sexo.toString());
//		medico.setFechaNacimiento(java.sql.Date.valueOf(fechaNacimiento));
//		medico.setDireccion(direccion);
//		medico.setLocalidad(localidad);
//		medico.setEmail(email);
//		medico.setTelefono(telefono);
//		medico.setDiasTrabajo(diasTrabajo);
//		medico.setHorarioTrabajo(horarioTrabajo);
//		medico.setEstado(true);
//		
//		Especialidad esp = service.getEspecialidadById(especialidad); 
//		
//		medico.setEspecialidad(esp);
//
//		
//		if(this.MedicoServicio.addMedico(medico)) {
//			MV.setViewName("redirect:/listarMedicosActivos.html");
//			return MV;
//		}else {
//			System.out.println("El medico ha ha sido agregado");
//		}
//		
//		MV.setViewName("redirect:/altaMedico.html");
//		return MV;
//		
//	}
//
//	
	
	// **************** PACIENTES ****************
/*
	@RequestMapping(value = "/altaPaciente.html", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView altaPaciente(String dni, String nombre, String apellido, String direccion, String localidad,
			String provincia, String fechaNacimiento, String correoElectronico, String telefono) {
		
		ModelAndView MV = new ModelAndView();

		System.out.println("DNI: " + dni);
		System.out.println("Nombre: " + nombre);
		System.out.println("Apellido: " + apellido);
		System.out.println("Dirección: " + direccion);
		System.out.println("Localidad: " + localidad);
		System.out.println("Provincia: " + provincia);
		System.out.println("Fecha de Nacimiento: " + fechaNacimiento);
		System.out.println("Correo Electrónico: " + correoElectronico);
		System.out.println("Teléfono: " + telefono);
		
		String Message = "";
		
		Paciente paciente = new Paciente();
		paciente.setDni(dni);
		paciente.setNombre(nombre);
		paciente.setApellido(apellido);
		paciente.setDireccion(direccion);
		paciente.setLocalidad(localidad);
		paciente.setProvincia(provincia);
		paciente.setFechaNacimiento(fechaNacimiento);
		paciente.setCorreoElectronico(correoElectronico);
		paciente.setTelefono(telefono);
		
		try {
			Pacienteservice.insertarPaciente(paciente);

		} catch (Exception e) {
			System.out.println("NO SE PUEDO INSERTAR");
			System.out.println("Error: " + e.getMessage());
		}

		finally {

		}
		MV.setViewName("Pacientes_agregar");
		return MV;

	}
	
	@RequestMapping(value = "/listarPacientes.html", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView listarPacientes() {
		ModelAndView MV = new ModelAndView();

		System.out.println("LISTA DE PACIENTES");

		MV.addObject("listaPacientes", this.Pacienteservice.obtenerPacientes());
		MV.setViewName("Pacientes_listar");
		return MV;

	}
		
	*/

	// **************** ESPECIALIDADES ****************

	@RequestMapping(value = "/altaEspecialidad.html", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView altaEspecialidad(String nombreEspecialidad) {
		ModelAndView MV = new ModelAndView();

		System.out.println("Especialidad: " + nombreEspecialidad);

		String Message = "";

		Especialidad especialidad = new Especialidad();
		especialidad.setNombre(nombreEspecialidad);

		System.out.println("nombreEspecialidad: '" + nombreEspecialidad + "'");
		System.out.println("especialidad.getNombre(): '" + especialidad.getNombre() + "'");

		try {
			service.insertarEspecialidad(especialidad);

		} catch (Exception e) {
			System.out.println("NO SE PUEDO INSERTAR");
			System.out.println("Error: " + e.getMessage());
		}

		finally {

		}

		MV.setViewName("Especialidades_agregar");
		return MV;

	}

	@RequestMapping(value = "/listarEspecialidades.html", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView listarEspecialidades() {
		ModelAndView MV = new ModelAndView();

		System.out.println("LISTA DE ESPECIALIDADES");

		MV.addObject("listaEspecialidades", this.service.obtenerEspecialidades());
		MV.setViewName("Especialidades_listar");
		return MV;

	}
	
	///******* ASIGNAR TURNOS ********
	/*
	@RequestMapping(value = "/asignarTurnos.html", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView asignarTurnos() {
		
		ModelAndView MV = new ModelAndView();
		
		/// OBTENGO LOS MEDICOS, PACIENTES, ESPECIALIDADES
		MV.addObject("listaPacientes", this.Pacienteservice.obtenerPacientes());
		MV.addObject("listaMedicos", this.MedicoServicio.obtenerMedicos());
		MV.addObject("listaEspecialidades", this.service.obtenerEspecialidades());
		
		MV.setViewName("asignarTurnos");
				
		return MV;

	}*/
	/*
	/// ***** CLIC SOBRE SISTEMA DE GESTION MEDICA *****
	@RequestMapping(value = "/irHomeAdmin.html", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView irHomeAdmin() {
		
		System.out.println("no soy de aqui");
		
		ModelAndView MV = new ModelAndView();
		
		MV.setViewName("HomeAdmin");
				
		return MV;

	}
	*/
}