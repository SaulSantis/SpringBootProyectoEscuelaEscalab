package proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "usuario")
@ApiModel(description = "Usuario con acceso a la Api Escuela")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @ApiModelProperty(notes = "Nombre debe tener entre 4 y 50 caracteres")
    @Column(name = "nombre", length = 50)
    @Size(min = 4, max = 50, message = "Debes ingresar un Nombre válido")
    @NotEmpty
    private String nombre;

    @ApiModelProperty(notes = "La clave debe tener entre 8 y 12 caracteres")
    @Column(name = "clave")
    @Min(value = 8, message = "La clave debe tener entre 8 y 12 caracteres")
    @Max(value = 12, message = "La clave debe tener entre 8 y 12 caracteres")
    @NotEmpty
    private String clave;

    @ApiModelProperty(notes = "Estado no debe ser nulo")
    @Column(name = "estado")
    @NotEmpty
    private Boolean estado;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_rol",
            joinColumns = @JoinColumn(name = "id_usuario", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_rol", nullable = false))
    private List<Rol> roles;

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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
}
