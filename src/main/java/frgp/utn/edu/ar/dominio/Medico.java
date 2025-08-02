package frgp.utn.edu.ar.dominio;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Medico")
public class Medico {
    
    @Id
    @Column(name = "legajo")
    private Integer legajo;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellido")
    private String apellido;
    
    @Column(name = "sexo")
    private String sexo;
    
    @Column(name = "fechaNacimiento")
    private String fechaNacimiento;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "localidad")
    private String localidad;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "telefono")
    private String telefono;
    
    @Column(name = "diasTrabajo")
    private String diasTrabajo;
    
    @Column(name = "horarioTrabajo")
    private String horarioTrabajo;
    
    @Column
	private Boolean estado;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario", referencedColumnName = "usuario")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "id_especialidad", referencedColumnName = "id")
    private Especialidad especialidad;
    
    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Turno> turnos;


    public Medico() {
    }

    public Medico(Integer legajo, String nombre, String apellido, String sexo, 
                String fechaNacimiento, String direccion, String localidad, 
                String email, String telefono, String diasTrabajo, 
                String horarioTrabajo, Boolean estado, Usuario usuario, Especialidad especialidad) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.localidad = localidad;
        this.email = email;
        this.telefono = telefono;
        this.diasTrabajo = diasTrabajo;
        this.horarioTrabajo = horarioTrabajo;
        this.estado = estado;
        this.usuario = usuario;
        this.especialidad = especialidad;
    }
    
    // Agregar getters y setters para la lista de turnos
    public List<Turno> getTurnos() {
        return turnos;
    }

    public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDiasTrabajo() {
		return diasTrabajo;
	}

	public void setDiasTrabajo(String diasTrabajo) {
		this.diasTrabajo = diasTrabajo;
	}

	public String getHorarioTrabajo() {
		return horarioTrabajo;
	}

	public void setHorarioTrabajo(String horarioTrabajo) {
		this.horarioTrabajo = horarioTrabajo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    // toString (actualizado para no incluir la lista completa de turnos)
    @Override
    public String toString() {
        return "Medico{" +
                "legajo=" + legajo +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", sexo='" + sexo + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", direccion='" + direccion + '\'' +
                ", localidad='" + localidad + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", diasTrabajo='" + diasTrabajo + '\'' +
                ", horarioTrabajo='" + horarioTrabajo + '\'' +
                ", usuario=" + (usuario != null ? usuario.toString() : "null") +
                ", especialidad=" + (especialidad != null ? especialidad.getNombre() : "null") +
                '}';
    }

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
}