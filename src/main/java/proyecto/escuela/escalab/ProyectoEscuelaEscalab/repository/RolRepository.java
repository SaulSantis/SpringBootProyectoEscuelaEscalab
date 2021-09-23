package proyecto.escuela.escalab.ProyectoEscuelaEscalab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Role;

public interface RolRepository extends JpaRepository<Role, Integer> {

    Role findByNombreRol(String nombreRol);
}
