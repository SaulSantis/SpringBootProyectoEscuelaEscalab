package proyecto.escuela.escalab.ProyectoEscuelaEscalab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Asignatura;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.exceptions.ModelNotFoundException;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.repository.AsignaturaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AsignaturaServiceImpl implements AsignaturaService{

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Override
    public List<Asignatura> findAll() {
        List<Asignatura> asignaturaList = asignaturaRepository.findAll();
        if (asignaturaList.isEmpty())
            throw new ModelNotFoundException("No existen Asignaturas en la base de datos");
        return asignaturaRepository.findAll();
    }

    @Override
    public Asignatura findById(Integer id) {
        Optional<Asignatura> asignaturaOptional = asignaturaRepository.findById(id);
        if (asignaturaOptional.isPresent()){
            return asignaturaOptional.get();
        }else {
            throw new ModelNotFoundException("" + id + " no existe en nuestra base de datos");
        }
    }

    @Override
    public Asignatura findByNombreAndJornada(String nombre, String jornada) {
        Asignatura asignatura = new Asignatura();
        if (nombre == null || nombre.equalsIgnoreCase("")) {
            if (jornada != null && !"".equalsIgnoreCase(nombre)) {
                asignatura = asignaturaRepository.findAsignaturaByJornada(jornada);
            }
        } else {
            if (jornada == null || "".equalsIgnoreCase(jornada)) {
                asignatura = asignaturaRepository.findAsignaturaByNombre(nombre);
            } else {
                asignatura = asignaturaRepository.findAsignaturaByNombreAndJornada(nombre, jornada);
            }
        }
        return asignatura;
    }

    @Override
    public Asignatura save(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    @Override
    public Asignatura update(Asignatura asignatura, Integer id) {
        Asignatura asignaturaupdate = new Asignatura();
        if (id != null && id > 0) {
            Optional<Asignatura> optionalAsignatura = asignaturaRepository.findById(id);
            if (optionalAsignatura.isPresent()) {
                asignatura.setId(id);
                asignaturaupdate = asignaturaRepository.save(asignatura);
            }
        } else {
            throw new ModelNotFoundException("" + id + " no existe en nuestra base de datos");
        }
        return asignaturaupdate;
    }

    @Override
    public void deleteById(Integer id) {
        boolean exists = asignaturaRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("" + id + " no existe en nuestra base de datos");
        }
        asignaturaRepository.deleteById(id);
    }
}
