package proyecto.escuela.escalab.ProyectoEscuelaEscalab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByUserName(String userName);

    Usuario findOneByUserName(String userName);
}
