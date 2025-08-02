package frgp.utn.edu.ar.entidad;

import javax.persistence.*;

@Entity
@Table(name = "Medico")
public class Medico {
    
    @Id
    @Column(name = "legajo")
    private Integer legajo;
    
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    
    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;
    
    @Column(name = "sexo", length = 1)
    private String sexo;
    
    @Column(name = "fechaNacimiento")
    private String fechaNacimiento;
    
    @Column(name = "direccion", length = 100)
    private String direccion;
    
    @Column(name = "localidad", length = 50)
    private String localidad;
    
    @Column(name = "email", length = 100)
    private String email;
    
    @Column(name = "telefono", length = 20)
    private String telefono;
    
    @Column(name = "diasTrabajo", length = 50)
    private String diasTrabajo;
    
    @Column(name = "horarioTrabajo", length = 50)
    private String horarioTrabajo;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario", referencedColumnName = "usuario")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "id_especialidad", referencedColumnName = "id")
    private Especialidad especialidad;
    


    // Constructor vacío requerido por Hibernate
    public Medico() {
    }

    // Constructor completo
    public Medico(Integer legajo, String nombre, String apellido, String sexo, 
                String fechaNacimiento, String direccion, String localidad, 
                String email, String telefono, String diasTrabajo, 
                String horarioTrabajo, Usuario usuario, Especialidad especialidad) {
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
        this.usuario = usuario;
        this.especialidad = especialidad;
    }

    // Getters y Setters
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
}