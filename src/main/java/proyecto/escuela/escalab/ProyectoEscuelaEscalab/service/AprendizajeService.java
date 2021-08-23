package proyecto.escuela.escalab.ProyectoEscuelaEscalab.service;

import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Aprendizaje;

import java.util.List;

public interface AprendizajeService {

    List<Aprendizaje> findAll();

    Aprendizaje findById(Integer id);

    Aprendizaje save(Aprendizaje aprendizaje);

    Aprendizaje update(Aprendizaje aprendizaje, Integer id);

    void deleteById(Integer id);
}
