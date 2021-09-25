package proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "apoderado")
@ApiModel(description = "Apoderados pertenecientes a Alumno")
public class Apoderado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apoderado")
    private Integer id;

    @ApiModelProperty(notes = "Nombres debe tener entre 4 y 50 caracteres")
    @Column(name = "nombres", length = 50)
    @Size(min = 4, max = 50, message = "Debes ingresar un Nombre válido")
    @NotEmpty
    private String nombres;

    @ApiModelProperty(notes = "Apellidos debe tener entre 4 y 50 caracteres")
    @Column(name = "apellidos", length = 50)
    @Size(min = 4, max = 50, message = "Debes ingresar ambos Apellidos")
    @NotEmpty
    private String apellidos;

    @ApiModelProperty(notes = "Parentesco debe tener entre 4 y 50 caracteres")
    @Column(name = "parentesco", length = 50)
    @Size(min = 4, max = 50, message = "Debes ingresar un Parentesco válido")
    @NotEmpty
    private String parentesco;

    @ApiModelProperty(notes = "Fecha de nacimiento no debe ser nula")
    @Column(name = "fecha_nacimiento")
    @NotNull
    private LocalDate fecha_nacimiento;

    @ApiModelProperty(notes = "Dni debe tener entre 9 y 10 caracteres")
    @Column(name = "dni", length = 10)
    @Size(min = 9, max = 10, message = "Debes ingresar un Dni válido")
    @NotEmpty
    private String dni;

    @ApiModelProperty(notes = "Dirección debe tener entre 4 y 50 caracteres")
    @Column(name = "direccion", length = 50)
    @Size(min = 4, max = 50, message = "Debes ingresar una Dirección válida")
    @NotEmpty
    private String direccion;

    @ApiModelProperty(notes = "Teléfono debe tener entre 9 y 12 caracteres")
    @Column(name = "telefono", length = 12)
    @Size(min = 9, max = 12, message = "Debes ingresar un Teléfono válido")
    @NotEmpty
    private String telefono;

    @ApiModelProperty(notes = "Email debe tener entre 4 y 50 caracteres")
    @Column(name = "email", length = 50)
    @Size(min = 4, max = 50, message = "Debes ingresar un email válido")
    @Email(message = "Debes ingresar un tipo de Email válido")
    @NotEmpty
    private String email;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_alumno", nullable = false, updatable = false)
    private Alumno alumno;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
}
