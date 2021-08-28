package proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu")
    private Integer id;

    @Column(name = "nombre", length = 50)
    @Size(min = 4, max = 50, message = "Debes ingresar un Nombre válido")
    @NotEmpty
    private String nombre;

    @Column(name = "url", length = 50)
    @NotEmpty
    private String url;

    @Column(name = "icono")
    @NotEmpty
    private LocalDateTime icono;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "menu_rol",
            joinColumns = @JoinColumn(name = "id_menu", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_rol", nullable = false))
    private List<Rol> roles;
}
