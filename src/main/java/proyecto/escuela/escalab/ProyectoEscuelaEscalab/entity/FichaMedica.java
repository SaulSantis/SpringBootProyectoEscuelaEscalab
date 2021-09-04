package proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "ficha_medica")
public class FichaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ficha")
    private Integer id;

    @Column(name = "fecha")
    @NotNull
    private LocalDate fecha;

    @Column(name = "edad")
    @NotNull
    private Integer edad;

    @Column(name = "peso")
    @NotNull
    private Double peso;

    @Column(name = "estatura")
    @NotNull
    private Double estatura;

    @Column(name = "diabetico")
    @NotNull
    private Boolean diabetico;

    @Column(name = "problemasCorazon")
    @NotNull
    private Boolean problemasCorazon;

    @Column(name = "alergias")
    @NotNull
    private Boolean alergias;

    @Column(name = "discapacidad")
    @NotEmpty
    private String discapacidad;

    @Column(name = "imagen")
    @NotEmpty
    private String imagen;

    @ManyToOne
    @JoinColumn(name = "id_alumno", nullable = false)
    private Alumno alumno;

}
