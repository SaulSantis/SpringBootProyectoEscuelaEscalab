package proyecto.escuela.escalab.ProyectoEscuelaEscalab.Service;

import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Aprendizaje;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Curso;

import java.util.List;

public interface AprendizajeService {

    List<Aprendizaje> findAll();

    Aprendizaje findById(Integer id);

    Aprendizaje save(Aprendizaje aprendizaje);

    Aprendizaje update(Aprendizaje aprendizaje, Integer id);

    void deleteById(Integer id);
}
