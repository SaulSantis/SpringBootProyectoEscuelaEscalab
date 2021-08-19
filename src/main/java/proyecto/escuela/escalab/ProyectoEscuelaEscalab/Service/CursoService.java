package proyecto.escuela.escalab.ProyectoEscuelaEscalab.Service;

import io.swagger.models.auth.In;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Curso;

import java.util.List;

public interface CursoService {

    List<Curso> findAll();

    Curso findById(Integer id);

    Curso findByNombreAndJornada(String nombre, String jornada);

    Curso save(Curso curso );

    Curso update(Curso curso, Integer id);

    void deleteById(Curso curso, Integer id);

//    Curso delete(Integer id);
}