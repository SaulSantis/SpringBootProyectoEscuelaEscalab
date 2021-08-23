package proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@Table(name = "profesor")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_profesor")
    private Integer id;

    @Column(name = "nombres", length = 50)
    @Size(min = 4, max = 50, message = "Debes ingresar ambos Nombres")
    @NotEmpty
    private String nombres;

    @Column(name = "apellidos", length = 50)
    @Size(min = 4, max = 50, message = "Debes ingresar ambos Apellidos")
    @NotEmpty
    private String apellidos;

    @Column(name = "dni", length = 10)
    @Size(min = 9, max = 10, message = "Debes ingresar un Dni válido")
    @NotEmpty
    private String dni;

    @Column(name = "direccion", length = 50)
    @Size(min = 4, max = 50, message = "Debes ingresar una Dirección válida")
    @NotEmpty
    private String direccion;

    @Column(name = "telefono", length = 12)
    @Size(min = 9, max = 12, message = "Debes ingresar un Teléfono válido")
    @NotEmpty
    private String telefono;

    @Column(name = "email", length = 50)
    @Size(min = 4, max = 50, message = "Debes ingresar un Nombre válido")
    @Email(message = "Debes ingresar un tipo de Email válido")
    @NotEmpty
    private String email;

    @Column(name = "imagen")
    private String imagen;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "curso_profesor",
            joinColumns = @JoinColumn(name = "id_profesor", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_curso", nullable = false))
    private List<Curso> curso;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "profesor_asignatura",
            joinColumns = @JoinColumn(name = "id_profesor", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_asignatura", nullable = false))
    private List<Profesor> profesor;



}
