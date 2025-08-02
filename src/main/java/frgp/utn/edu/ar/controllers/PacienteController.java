package frgp.utn.edu.ar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import frgp.utn.edu.ar.dominio.Medico;
import frgp.utn.edu.ar.dominio.Paciente;
import frgp.utn.edu.ar.servicio.PacienteServicio;

@Controller
public class PacienteController {

	@Autowired
	private PacienteServicio pacienteService;
	
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
			pacienteService.insertarPaciente(paciente);

		} catch (Exception e) {
			System.out.println("NO SE PUEDO INSERTAR");
			System.out.println("Error: " + e.getMessage());
		}

		finally {

		}
		MV.setViewName("Pacientes_agregar");
		return MV;

	}

	@RequestMapping(value = "/bajaPaciente.html", method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView deletePaciente(@RequestParam("dni") String dni, Model model ){
		
		ModelAndView MV = new ModelAndView();
		
		System.out.println(dni);
		
		try {
			Paciente m = pacienteService.ReadOne(dni);
			System.out.println(m.getApellido().toString());
			m.setEstado(false);
			pacienteService.Delete(m);
			System.out.println("El paciente fue dado de baja correctamente");
		    MV.setViewName("redirect:/listarPacientes.html?bajaExitosa=true");
		} catch (Exception e) {
			System.out.println("El Paciente no ha podido ser dado de baja");
		    MV.setViewName("redirect:/listarPacientes.html?bajaExitosa=false");
		}
		return MV;
		
	}
	
	@RequestMapping(value = "/listarPacientes.html", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView listarPacientes() {
		ModelAndView MV = new ModelAndView();

		System.out.println("LISTA DE PACIENTES");

		MV.addObject("listaPacientes", this.pacienteService.obtenerPacientes());
		MV.setViewName("Pacientes_listar");
		return MV;

	}
		
	@RequestMapping(value = "/editarPaciente.html", method = RequestMethod.GET)
	public ModelAndView mostrarFormularioEdicion(@RequestParam("dni") String dni) {
	    ModelAndView MV = new ModelAndView();

	    Paciente paciente = pacienteService.ReadOne(dni);
	    MV.addObject("paciente", paciente);
	    MV.setViewName("Pacientes_editar");

	    return MV;
	}

	@RequestMapping(value = "/editarPaciente.html", method = RequestMethod.POST)
	public ModelAndView editarPaciente(String dni,String nombre,String apellido,String direccion,String localidad,String provincia,String fechaNacimiento,String correoElectronico,String telefono) {

	    ModelAndView MV = new ModelAndView();

	    Paciente paciente = pacienteService.ReadOne(dni);

	    paciente.setNombre(nombre);
	    paciente.setApellido(apellido);
	    paciente.setDireccion(direccion);
	    paciente.setLocalidad(localidad);
	    paciente.setProvincia(provincia);
	    paciente.setFechaNacimiento(fechaNacimiento);
	    paciente.setCorreoElectronico(correoElectronico);
	    paciente.setTelefono(telefono);

	    try {
	        pacienteService.Update(paciente);
	        MV.setViewName("redirect:/listarPacientes.html?modificacionExitosa=true");
	    } catch (Exception e) {
	        MV.setViewName("redirect:/listarPacientes.html?modificacionExitosa=false");
	    }

	    return MV;
	}


}
