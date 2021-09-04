package proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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

    @OneToMany(mappedBy = "asignatura")
    private List<Contenido> contenido;

}
