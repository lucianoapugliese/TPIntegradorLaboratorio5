package frgp.utn.edu.ar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.dominio.Especialidad;
import frgp.utn.edu.ar.dominio.Medico;
import frgp.utn.edu.ar.servicio.EspecialidadServicio;
import frgp.utn.edu.ar.servicio.MedicoServicio;

@Controller
public class MedicoController {
	
	@Autowired
	private MedicoServicio medicoServicio;
	
	@Autowired
	private EspecialidadServicio especialidadServicio;

	


	
	
	
	
	
	@RequestMapping(value = "/listarMedicos.html", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView listarMedicos() {
		ModelAndView MV = new ModelAndView();

		System.out.println("LISTA DE MEDICOS");

		MV.addObject("listaMedicos", this.medicoServicio.obtenerMedicos());
		MV.setViewName("Medicos_listar");
		return MV;

	}
		
	@RequestMapping(value = "/bajaMedico.html", method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView deleteDoctor(@RequestParam("legajo") Integer legajo, Model model ){
		
		ModelAndView MV = new ModelAndView();
		
		System.out.println(legajo);
		
		try {
			Medico m = medicoServicio.ReadOne(legajo);
			System.out.println(m.getApellido().toString());
			m.setEstado(false);
			medicoServicio.Delete(m);
			System.out.println("El medico fue dado de baja correctamente");
			MV.setViewName("redirect:/listarMedicosActivos.html");
		} catch (Exception e) {
			System.out.println("El medico no ha podido ser dado de baja");
		}
		
		MV.setViewName("redirect:/listarMedicosActivos.html");
		return MV;
		
	}
	
	@RequestMapping(value = "/listarMedicosActivos.html", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView listarMedicosActivos() {
		ModelAndView MV = new ModelAndView();

		System.out.println("LISTA DE MEDICOS ACTIVOS");

		MV.addObject("listaMedicos", this.medicoServicio.medicosActivos());
		MV.setViewName("Medicos_listar");
		return MV;

	}
	
	// Muestra el formulario para agregar médico
	@RequestMapping(value = "/altaMedico.html", method = RequestMethod.GET)
	public ModelAndView mostrarFormularioAltaMedico() {
		ModelAndView MV = new ModelAndView("Medicos_agregar");
		MV.addObject("especialidades", this.especialidadServicio.obtenerEspecialidades());
		return MV;
	}

	// Guarda los datos del médico
	@RequestMapping(value = "/altaMedico.html", method = RequestMethod.POST)
	public ModelAndView guardarMedico(
		Integer legajo, String nombre, String apellido, String sexo, 
		String fechaNacimiento, String direccion, String localidad, 
		String email, String telefono, String[] diasTrabajo, 
		String horarioInicio, String horarioFin, Boolean estado, Integer especialidad) {

		ModelAndView MV = new ModelAndView();

		Medico medico = new Medico();
		medico.setLegajo(legajo);
		medico.setNombre(nombre);
		medico.setApellido(apellido);
		medico.setSexo(sexo);
		medico.setFechaNacimiento(fechaNacimiento);
		medico.setDireccion(direccion);
		medico.setLocalidad(localidad);
		medico.setEmail(email);
		medico.setTelefono(telefono);

		String dias = String.join(", ", diasTrabajo);
		medico.setDiasTrabajo(dias);

		/*if (horaInicio == null || horaFin == null || Integer.parseInt(horaInicio) >= Integer.parseInt(horaFin)) {
			MV.setViewName("Medicos_agregar");
			MV.addObject("mensaje", "El horario de inicio debe ser menor al de finalización.");
			MV.addObject("tipoMensaje", "error");
			MV.addObject("especialidades", especialidadServicio.obtenerEspecialidades());
			return MV;
		}*/

		medico.setHorarioTrabajo(horarioInicio + " - " + horarioFin);
		medico.setEstado(true);

		Especialidad esp = especialidadServicio.getEspecialidadById(especialidad); 
		medico.setEspecialidad(esp);

		if(this.medicoServicio.addMedico(medico)) {
		    MV.setViewName("redirect:/altaMedico.html?medicoConfirmado=true");
		} else {
		    MV.setViewName("redirect:/altaMedico.html?medicoConfirmado=false");
		}

		return MV;
	}


	@RequestMapping(value = "/editarMedico.html", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView editarMedico(@RequestParam("legajo") Integer legajo) {
	    ModelAndView MV = new ModelAndView();

	    Medico medico = medicoServicio.ReadOne(legajo);

	    MV.addObject("medico", medico);
	    MV.addObject("especialidades", this.especialidadServicio.obtenerEspecialidades());
	    MV.setViewName("Medicos_editar");
	    return MV;
	}

	@RequestMapping(value = "/guardarCambiosMedico.html", method = { RequestMethod.POST })
	public ModelAndView guardarCambiosMedico(Integer legajo, String nombre, String apellido, String sexo, 
	        String fechaNacimiento, String direccion, String localidad, 
	        String email, String telefono, String diasTrabajo, 
	        String horarioTrabajo, Boolean estado, Integer especialidad) {

	    ModelAndView MV = new ModelAndView();
	    Medico medico = medicoServicio.ReadOne(legajo);

	    medico.setNombre(nombre);
	    medico.setApellido(apellido);
	    medico.setSexo(sexo);
	    medico.setFechaNacimiento(fechaNacimiento);
	    medico.setDireccion(direccion);
	    medico.setLocalidad(localidad);
	    medico.setEmail(email);
	    medico.setTelefono(telefono);
	    medico.setDiasTrabajo(diasTrabajo);
	    medico.setHorarioTrabajo(horarioTrabajo);
	    medico.setEstado(estado);

	    Especialidad esp = especialidadServicio.getEspecialidadById(especialidad); 
	    medico.setEspecialidad(esp);

	    medicoServicio.update(medico);

	    MV.setViewName("redirect:/listarMedicosActivos.html");
	    return MV;
	}

	
}
