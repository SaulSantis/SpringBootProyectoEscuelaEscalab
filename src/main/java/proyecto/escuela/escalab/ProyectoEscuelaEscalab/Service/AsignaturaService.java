package proyecto.escuela.escalab.ProyectoEscuelaEscalab.Service;

import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Asignatura;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Curso;

import java.util.List;

public interface AsignaturaService {

    List<Asignatura> findAll();

    Asignatura findById(Integer id);

    Asignatura findByNombreAndJornada(String nombre, String jornada);

    Asignatura save(Asignatura asignatura);

    Asignatura update(Asignatura asignatura, Integer id);

    void deleteById(Integer id);




}
