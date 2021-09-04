package proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "registro_academico")
public class RegistroAcademico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro_academico")
    private Integer id;

    @Column(name = "fecha")
    private LocalDate fecha_registro;

    @ManyToOne
    @JoinColumn(name = "id_alumno", nullable = false)
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "id_profesor", nullable = false)
    private Profesor profesor;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

}
