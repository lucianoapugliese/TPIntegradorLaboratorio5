package frgp.utn.edu.ar.entidad;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    
    @Id
    @Column(name = "usuario", length = 255)
    private String nombreUsuario;
    
    @Column(name = "password", length = 255)
    private String password;
    
    @Column(name = "rol", length = 255)
    private String rol;
    
    // CONSTRUCTOR VACÍO OBLIGATORIO
    public Usuario() {
        // Constructor sin parámetros requerido por Hibernate/Spring
    }
    
    // Constructor con parámetros (opcional pero recomendado)
    public Usuario(String nombreUsuario, String password, String rol) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.rol = rol;
    }
    
    // GETTERS Y SETTERS OBLIGATORIOS
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
}