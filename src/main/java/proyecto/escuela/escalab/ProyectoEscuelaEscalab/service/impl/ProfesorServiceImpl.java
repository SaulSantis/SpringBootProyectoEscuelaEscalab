package proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Profesor;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.exceptions.ModelNotFoundException;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.repository.ProfesorRepository;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.ProfesorService;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public List<Profesor> findAll() {
        List<Profesor> profesorsList = profesorRepository.findAll();
        if (profesorsList.isEmpty())
            throw new ModelNotFoundException("No existen Profesores en la base de datos");
        return profesorRepository.findAll();
    }

    @Override
    public Profesor findById(Integer id) {
        Optional<Profesor> profesorOptional = profesorRepository.findById(id);
        if (profesorOptional.isPresent()){
            return profesorOptional.get();
        }else {
            throw new ModelNotFoundException("" + id + " no existe en nuestra base de datos");
        }
    }

    @Override
    public Profesor save(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    @Override
    public Profesor update(Profesor profesor, Integer id) {
        Profesor profesorUpdate = new Profesor();
        if (id != null && id > 0) {
            Optional<Profesor> optionalProfesor = profesorRepository.findById(id);
            if (optionalProfesor.isPresent()) {
                profesor.setId(id);
                profesorUpdate = profesorRepository.save(profesor);
            }
        } else {
            throw new ModelNotFoundException("" + id + " no existe en nuestra base de datos");
        }
        return profesorUpdate;
    }

    @Override
    public void deleteById(Integer id) {
        boolean exists = profesorRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("" + id + " no existe en nuestra base de datos");
        }
        profesorRepository.deleteById(id);
    }
}
