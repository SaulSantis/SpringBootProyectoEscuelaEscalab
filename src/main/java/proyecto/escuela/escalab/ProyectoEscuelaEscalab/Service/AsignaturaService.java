package proyecto.escuela.escalab.ProyectoEscuelaEscalab.Service;

import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Asignatura;

import java.util.List;

public interface AsignaturaService {

    List<Asignatura> findAll();

    Asignatura save(Asignatura asignatura);


}
