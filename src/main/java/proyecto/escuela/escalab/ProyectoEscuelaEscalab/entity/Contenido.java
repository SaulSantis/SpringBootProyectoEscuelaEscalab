package proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "contenido")
public class Contenido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contenido")
    private Integer id;

    @Column(name = "nombre", length = 50)
    @Size(min = 4, max = 50, message = "Debes ingresar un Nombre válido")
    @NotEmpty
    private String nombre;

    @Column(name = "detalle_Contenido", length = 200)
    @Size(max = 200, message = "El contenido debe tener máximo 200 caracteres")
    @NotEmpty
    private String detalleContenido;

    @ManyToOne
    @JoinColumn(name = "id_asignatura",nullable = false)
    @JsonIgnoreProperties("contenido")
    private Asignatura asignatura;

}
