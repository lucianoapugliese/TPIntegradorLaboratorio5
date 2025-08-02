package frgp.utn.edu.ar.controllers;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.dominio.Especialidad;
import frgp.utn.edu.ar.dominio.Medico;
import frgp.utn.edu.ar.dominio.Paciente;
import frgp.utn.edu.ar.dominio.Turno;
import frgp.utn.edu.ar.dominio.Turno.EstadoTurno;
import frgp.utn.edu.ar.servicio.EspecialidadServicio;
import frgp.utn.edu.ar.servicio.MedicoServicio;
import frgp.utn.edu.ar.servicio.PacienteServicio;
import frgp.utn.edu.ar.servicio.TurnoServicio;

@Controller
public class TurnoController {
	
	@Autowired
	private TurnoServicio turnoServicio;
	
	@Autowired
	private EspecialidadServicio especialidadServicio;
	
	@Autowired
	private PacienteServicio pacienteservice;	

	
	@Autowired
	private MedicoServicio medicoServicio;
	
	
/*	@RequestMapping(value = "/asignarTurnos.html", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView asignarTurnos() {
		
		ModelAndView MV = new ModelAndView();
		
		/// OBTENGO LOS MEDICOS, PACIENTES, ESPECIALIDADES
		MV.addObject("listaPacientes", this.pacienteservice.obtenerPacientes());
		MV.addObject("listaMedicos", this.medicoServicio.obtenerMedicos());
		MV.addObject("listaEspecialidades", this.especialidadServicio.obtenerEspecialidades());
		
		MV.setViewName("asignarTurnos");
				
		return MV;

	}*/
	
	
	/*
	@RequestMapping(value = "/asignarTurnos.html", method = { RequestMethod.POST })
	public ModelAndView asignarTurnos(Integer medicoId, String pacienteDni, String fecha, String hora) {
		ModelAndView MV = new ModelAndView();
		Medico medico = medicoServicio.ReadOne(medicoId);
		Paciente paciente = pacienteservice.ReadOne(pacienteDni);
		Turno turno = new Turno();

		turno.setFecha(fecha);
		turno.setHora(hora);
		turno.setMedico(medico);
		turno.setPaciente(paciente);
		turno.setObservacion("");
		turno.setEstado(EstadoTurno.AUSENTE);
		
		
		System.out.println("Especialidad: " + medico.getEspecialidad().getNombre());
		System.out.println("Médico: " + medico.getNombre() + ' ' + medico.getApellido());
		System.out.println("Paciente: " + paciente.getNombre() + ' ' + paciente.getApellido());
		System.out.println("Fecha: " + fecha);
		System.out.println("Hora: " + hora);
		

		String Message = "";

		

/*		System.out.println("nombreEspecialidad: '" + nombreEspecialidad + "'");
		System.out.println("especialidad.getNombre(): '" + especialidad.getNombre() + "'");
*/
	/*
		try {
			turnoServicio.insertarTurno(turno);

		} catch (Exception e) {
			System.out.println("NO SE PUEDO INSERTAR");
			System.out.println("Error: " + e.getMessage());
		}

		finally {

		}

		MV.setViewName("asignarTurnos");
		return MV;

	}
	*/
	
	// GET: solo muestra el formulario
	@RequestMapping(value = "/asignarTurnos.html", method = RequestMethod.GET)
	public ModelAndView mostrarFormulario() {
		
		ModelAndView MV = new ModelAndView("asignarTurnos");
		MV.addObject("listaEspecialidades",especialidadServicio.obtenerEspecialidades());
		MV.addObject("listaMedicos",medicoServicio.obtenerMedicos());
		MV.addObject("listaPacientes",pacienteservice.obtenerPacientes());
		
	    return MV;
	}

	// POST: procesa el formulario
	@RequestMapping(value = "/asignarTurnos.html", method = RequestMethod.POST)
	public ModelAndView procesarFormulario(Integer medicoId, String pacienteDni, String fecha, String hora) {

	    ModelAndView MV = new ModelAndView("redirect:/listarTurnos.html?legajo=");

		MV.addObject("listaEspecialidades",especialidadServicio.obtenerEspecialidades());
		MV.addObject("listaMedicos",medicoServicio.obtenerMedicos());
		MV.addObject("listaPacientes",pacienteservice.obtenerPacientes());
	    
	    if (medicoId == null || pacienteDni == null || fecha == null || hora == null) {
	        MV.addObject("error", "Todos los campos son obligatorios.");
	        return MV;
	    }

	    Medico medico = medicoServicio.ReadOne(medicoId);
		Paciente paciente = pacienteservice.ReadOne(pacienteDni);
		Turno turno = new Turno();

		turno.setFecha(fecha);
		turno.setHora(hora);
		turno.setMedico(medico);
		turno.setPaciente(paciente);
		turno.setObservacion("");
		turno.setEstado(EstadoTurno.PROXIMO);

		try {
		    turnoServicio.insertarTurno(turno);
		    MV.addObject("turnoConfirmado", true);
		} catch (Exception e) {
		    System.out.println("NO SE PUEDO INSERTAR");
		    System.out.println("Error: " + e.getMessage());
		    MV.addObject("error", "No se pudo asignar el turno.");
		}


		finally {
		}
		MV.setViewName("asignarTurnos");
		return MV;
	}
	
	
	@RequestMapping(value = "/listarTurnos.html?legajo=", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView listarTurnos(@RequestParam("legajo") Integer legajo) {
		ModelAndView MV = new ModelAndView();

		System.out.println("LISTA DE TURNOS");

		if(legajo == null) {
		
		MV.addObject("listaTurnos", this.turnoServicio.obtenerTurnos());
		MV.setViewName("Turnos_listar");
		}
		else {
			MV.addObject("listaTurnos", this.turnoServicio.obtenerTurnosPorMedico(legajo.toString()));
			MV.setViewName("Turnos_listar");
		}
		return MV;

	}
	
	
	@RequestMapping(value = "/editarturno.html", method = RequestMethod.GET)
	public ModelAndView mostrarFormularioEdicion(int id) {
	    ModelAndView MV = new ModelAndView("editarTurno");


	    Turno turno = turnoServicio.getTurnoById(id);
	    
	    MV.addObject("turno", turno);
	    MV.addObject("listaEspecialidades", especialidadServicio.obtenerEspecialidades());
	    MV.addObject("listaMedicos", medicoServicio.obtenerMedicos());
	    MV.addObject("listaPacientes", pacienteservice.obtenerPacientes());

	    return MV;
	}

	@RequestMapping(value = "/verturno.html", method = RequestMethod.GET)
	public ModelAndView mostrarFormulario(int id) {
		ModelAndView MV = new ModelAndView("verTurno");
		
		
		Turno turno = turnoServicio.getTurnoById(id);
		
		String[] fecha = turno.getFecha().split("-");
		String[] hora = turno.getHora().split(":");
		LocalDate fechaActual = LocalDate.now();
		LocalTime horaActual = LocalTime.now();
		
		
		MV.addObject("turno", turno);
		MV.addObject("listaEspecialidades", especialidadServicio.obtenerEspecialidades());
		MV.addObject("listaMedicos", medicoServicio.obtenerMedicos());
		MV.addObject("listaPacientes", pacienteservice.obtenerPacientes());
		
		if(
				fechaActual.getYear()<= Integer.parseInt(fecha[0]) &&
				fechaActual.getMonthValue()<= Integer.parseInt(fecha[1]) &&
				fechaActual.getDayOfMonth()<= Integer.parseInt(fecha[2]) &&
				horaActual.getHour() <= Integer.parseInt(hora[0])
				)
			MV.addObject("EnHorario",true);
		
		return MV;
	}

	@RequestMapping(value = "/editarturno.html", method = RequestMethod.POST)
	public ModelAndView editarTurno(long id, Integer medicoId, String pacienteDni, String fecha, String hora, String observacion, String estado) {
	    ModelAndView MV = new ModelAndView("editarTurno");

	    try {
	        Medico medico = medicoServicio.ReadOne(medicoId);
	        Paciente paciente = pacienteservice.ReadOne(pacienteDni);

	        Turno turno = new Turno();
	        turno.setId(id);
	        turno.setMedico(medico);
	        turno.setPaciente(paciente);
	        turno.setFecha(fecha);
	        turno.setHora(hora);
	        turno.setObservacion(observacion);
	        turno.setEstado(Turno.EstadoTurno.valueOf(estado));

	        turnoServicio.update(turno);
	        MV.addObject("mensaje", "Turno editado correctamente.");
	        MV.addObject("tipoMensaje", "success");
	    } catch (Exception e) {
	    	System.out.println(e);
	        MV.addObject("mensaje", "Error al editar el turno.");
	        MV.addObject("tipoMensaje", "error");
	    }

	    
	    MV.addObject("turno", turnoServicio.getTurnoById(id));
	    MV.addObject("listaEspecialidades", especialidadServicio.obtenerEspecialidades());
	    MV.addObject("listaMedicos", medicoServicio.obtenerMedicos());
	    MV.addObject("listaPacientes", pacienteservice.obtenerPacientes());

	    return MV;
	}
	@RequestMapping(value = "/verturno.html", method = RequestMethod.POST)
	public ModelAndView verTurno(long id, Integer medicoId, String pacienteDni, String fecha, String hora, String observacion, String estado) {
		ModelAndView MV = new ModelAndView("verTurno");
		
		try {
			Turno turno = turnoServicio.getTurnoById(id);
			turno.setObservacion(observacion);
			turno.setEstado(Turno.EstadoTurno.valueOf(estado));
			
			turnoServicio.update(turno);
			MV.addObject("mensaje", "Turno editado correctamente.");
			MV.addObject("tipoMensaje", "success");
		} catch (Exception e) {
			System.out.println(e);
			MV.addObject("mensaje", "Error al editar el turno.");
			MV.addObject("tipoMensaje", "error");
		}
		
		
		MV.addObject("turno", turnoServicio.getTurnoById(id));
		MV.addObject("listaEspecialidades", especialidadServicio.obtenerEspecialidades());
		MV.addObject("listaMedicos", medicoServicio.obtenerMedicos());
		MV.addObject("listaPacientes", pacienteservice.obtenerPacientes());
		
		return MV;
	}

}
