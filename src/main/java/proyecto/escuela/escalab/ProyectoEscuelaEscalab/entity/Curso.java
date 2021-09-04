package proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Integer id;

    @ApiModelProperty(notes = "Nombre dene tener entre 4 y 50 caracteres")
    @Column(name = "nombre", length = 50)
    @Size(min = 4, max = 50, message = "Debes ingresar un Nombre válido")
    @NotEmpty
    private String nombre;

    @ApiModelProperty(notes = "Jornada dene tener entre 4 y 50 caracteres")
    @Column(name = "jornada", length = 50)
    @Size(min = 4, max = 50, message = "Debes ingresar un tipo de Jornada válido")
    @NotEmpty
    private String jornada;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "curso_asignatura",
            joinColumns = @JoinColumn(name = "id_curso", nullable = false),
            inverseJoinColumns = @JoinColumn(name="id_asignatura", nullable = false)
    )
    private List<Asignatura> asignatura;
}
