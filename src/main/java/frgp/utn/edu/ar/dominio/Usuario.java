package frgp.utn.edu.ar.dominio;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    
    @Id
    @Column(name = "usuario")
    private String nombreUsuario;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "rol")
    private String rol;
    
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Medico medico;
    
    // CONSTRUCTOR VACÍO OBLIGATORIO
    public Usuario() {
    }
    
    // Constructor con parámetros
    public Usuario(String nombreUsuario, String password, String rol) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.rol = rol;
    }
    
    
    public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	// Agregar getter y setter para médico
    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    // toString (actualizado)
    @Override
    public String toString() {
        return "Usuario{" +
                "nombreUsuario='" + nombreUsuario + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}