package proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "ficha_medica")
public class FichaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ficha")
    private Integer id;

    @Column(name = "edad")
    @Size
    @NotEmpty
    private Float edad;

    @Column(name = "peso")
    @Size
    @NotEmpty
    private Float peso;

    @Column(name = "talla")
    @Size
    @NotEmpty
    private Float talla;

    @Column(name = "diabetico")
    @Size
    @NotEmpty
    private Boolean diabetico;

    @Column(name = "problemasCorazon")
    @Size
    @NotEmpty
    private Boolean problemasCorazon;

    @Column(name = "alergias")
    @Size
    @NotEmpty
    private Boolean alergias;

    @Column(name = "discapacidad")
    @Size
    @NotEmpty
    private String discapacidad;

    @Column(name = "imagen")
    @Size
    @NotEmpty
    private String imagen;
}
