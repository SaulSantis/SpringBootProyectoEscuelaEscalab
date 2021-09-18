package proyecto.escuela.escalab.ProyectoEscuelaEscalab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Curso;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

    Curso findCursoByNombreAndJornada(String nombre, String jornada);

    Curso findCursoByNombre(String nombre);

    List<Curso> findCursoByJornada(String jornada);
}
