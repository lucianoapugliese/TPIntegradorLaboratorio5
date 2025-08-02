package frgp.utn.edu.ar.dominio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "paciente")
public class Paciente {

	@Id
	@Column(name = "dni")
	private String dni;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "localidad")
	private String localidad;

	@Column(name = "provincia")
	private String provincia;

	@Column(name = "fecha_nacimiento")
	private String fechaNacimiento;

	@Column(name = "correo_electronico")
	private String correoElectronico;

	@Column(name = "telefono")
	private String telefono;
	
	@Column
	private Boolean estado;

	// CONSTRUCTORES
	public Paciente() {
		// Constructor vacío requerido por Hibernate
	}

	public Paciente(String dni, String nombre, String apellido, String direccion, String localidad, String provincia,
			String fechaNacimiento, String correoElectronico, String telefono, Boolean estado) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
		this.fechaNacimiento = fechaNacimiento;
		this.correoElectronico = correoElectronico;
		this.telefono = telefono;
		this.estado = estado;
	}

	// GETTERS y SETTERS
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	// METODO TOSTRING
	@Override
	public String toString() {
		return "Paciente [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion
				+ ", localidad=" + localidad + ", provincia=" + provincia + ", fechaNacimiento=" + fechaNacimiento
				+ ", correoElectronico=" + correoElectronico + ", telefono=" + telefono + "]";
	}
	
	/// 
	
	@OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Turno> turnos;

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
}
