package proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "ficha_medica")
@ApiModel(description = "Ficha Medica pertenecientes a la Alumnos")
public class FichaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ficha")
    private Integer id;

    @ApiModelProperty(notes = "Fecha de registro no debe ser nula")
    @Column(name = "fecha")
    @NotNull
    private LocalDate fecha;

    @ApiModelProperty(notes = "Se debe ingresar edad entre 1 y 99")
    @Column(name = "edad")
    @Min(value = 1, message = "Debe ingresar edad entre 1 y 99")
    @Max(value = 100, message = "Debe ingresar edad entre 1 y 100")
    @NotNull
    private Integer edad;

    @ApiModelProperty(notes = "Se debe ingresar peso entre 1 y 100 Kilos")
    @Column(name = "peso")
    @Min(value = 1, message = "Debe ingresar kilos entre 1 y 200")
    @Max(value = 200, message = "Debe ingresar kilos entre 1 y 200")
    @NotNull
    private Double peso;

    @ApiModelProperty(notes = "Se debe ingresar estatura entre 1 y 2 metros")
    @Column(name = "estatura")
    @Min(value = 1,message = "Debe ingresar estatura entre 1 y 2 metros")
    @Max(value = 2, message = "Debe ingresar estatura entre 1 y 2 metros")
    @NotNull
    private Double estatura;

    @ApiModelProperty(notes = "Se debe ingresar true o false para diabético")
    @Column(name = "diabetico")
    @NotNull
    private Boolean diabetico;

    @ApiModelProperty(notes = "Se debe ingresar true o false para problemas al corazón")
    @Column(name = "problemasCorazon")
    @NotNull
    private Boolean problemas_corazon;

    @ApiModelProperty(notes = "Se debe ingresar true o false para alergias")
    @Column(name = "alergias")
    @NotNull
    private Boolean alergias;

    @ApiModelProperty(notes = "Se debe ingresar true o false para discapacidad")
    @Column(name = "discapacidad")
    @NotNull
    private Boolean discapacidad;

    @Column(name = "imagen")
    @NotEmpty
    private String imagen;

    @ManyToOne
    @JoinColumn(name = "id_alumno", nullable = false)
    private Alumno alumno;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getEstatura() {
        return estatura;
    }

    public void setEstatura(Double estatura) {
        this.estatura = estatura;
    }

    public Boolean getDiabetico() {
        return diabetico;
    }

    public void setDiabetico(Boolean diabetico) {
        this.diabetico = diabetico;
    }

    public Boolean getProblemas_corazon() {return problemas_corazon;}

    public void setProblemas_corazon(Boolean problemas_corazon) {this.problemas_corazon = problemas_corazon;}

    public Boolean getAlergias() {
        return alergias;
    }

    public void setAlergias(Boolean alergias) {
        this.alergias = alergias;
    }

    public Boolean getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(Boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
}
