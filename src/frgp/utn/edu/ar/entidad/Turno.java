package frgp.utn.edu.ar.entidad;

import javax.persistence.*;

@Entity
@Table(name = "turnos")
public class Turno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "medico_id")
	private Medico medico;

	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;

	@Column(name = "fecha")
	private String fecha;

	@Column(name = "hora")
	private String hora;

	@Column(name = "observacion")
	private String observacion;

	@Enumerated(EnumType.STRING)
	@Column(name = "estado")
	private EstadoTurno estado;

	public enum EstadoTurno {
		PRESENTE, AUSENTE
	}

	// CONSTRUCTORES
	public Turno() {
	}

	public Turno(Medico medico, Paciente paciente, String fecha, String hora, String observacion, String estado) {
		this.medico = medico;
		this.paciente = paciente;
		this.fecha = fecha;
		this.hora = hora;
		this.observacion = observacion;
		this.estado = EstadoTurno.valueOf(estado);
	}

	// GETTERS y SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public EstadoTurno getEstado() {
		return estado;
	}

	public void setEstado(EstadoTurno estado) {
		this.estado = estado;
	}

	// METODO TO STRING()
	@Override
	public String toString() {
		return "Turno [id=" + id + ", medico=" + medico.getApellido() + ", paciente=" + paciente.getApellido()
				+ ", fecha=" + fecha + ", hora=" + hora + ", observacion=" + observacion + ", estado=" + estado + "]";
	}
}
