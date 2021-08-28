package proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "asignatura")
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignatura")
    private Integer id;

    @Column(name = "nombre", length = 50)
    @Size(min = 4, max = 50, message = "Debes ingresar un Nombre válido")
    @NotEmpty
    private String nombre;

    @Column(name = "jornada", length = 50)
    @Size(min = 4, max = 50, message = "Debes ingresar un tipo de Jornada válido")
    @NotEmpty
    private String jornada;

    @Column(name = "horario")
    @NotEmpty
    private String horario;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "curso_asignatura",
            joinColumns = @JoinColumn(name = "id_curso", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_asignatura",nullable = false)
    )
    private List<Curso> curso;

}
