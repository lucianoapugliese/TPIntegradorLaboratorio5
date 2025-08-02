package frgp.utn.edu.ar.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "especialidad")
public class Especialidad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id")
	private int id;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	public Especialidad() {
	};

	public Especialidad(String nombre) { 
		super();
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Especialidad [id=" + id + ", nombre=" + nombre + "]";
	}
	
	///
	
	@OneToMany(mappedBy = "especialidad", fetch = FetchType.LAZY)
	private List<Medico> medicos;
}
