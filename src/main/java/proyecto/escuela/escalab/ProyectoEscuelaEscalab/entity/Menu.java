package proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "menu")
@ApiModel(description = "Menú de Api")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu")
    private Integer id;

    @ApiModelProperty(notes = "Nombre debe tener entre 4 y 50 caracteres")
    @Column(name = "nombre", length = 50)
    @Size(min = 4, max = 50, message = "Debes ingresar un Nombre válido")
    @NotEmpty
    private String nombre;

    @ApiModelProperty(notes = "url")
    @Column(name = "url", length = 50)
    @NotEmpty
    private String url;

    @ApiModelProperty(notes = "icono")
    @Column(name = "icono")
    @NotEmpty
    private LocalDateTime icono;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "menu_rol",
            joinColumns = @JoinColumn(name = "id_menu", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_rol", nullable = false))
    private List<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getIcono() {
        return icono;
    }

    public void setIcono(LocalDateTime icono) {
        this.icono = icono;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
