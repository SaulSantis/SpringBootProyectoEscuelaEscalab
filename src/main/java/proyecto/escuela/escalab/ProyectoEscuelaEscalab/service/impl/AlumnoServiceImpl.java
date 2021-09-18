package proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Alumno;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.exceptions.ModelNotFoundException;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.repository.AlumnoRepository;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.AlumnoService;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public List<Alumno> findAll() {
        List<Alumno> alumnoList = alumnoRepository.findAll();
        if (alumnoList.isEmpty())
            throw new ModelNotFoundException("No existen Alumnos en la base de datos");
        return alumnoRepository.findAll();
    }

    @Override
    public Alumno findById(Integer id) {
        Optional<Alumno> alumnoOptional = alumnoRepository.findById(id);
        if (alumnoOptional.isPresent()) {
            return alumnoOptional.get();
        } else {
            throw new ModelNotFoundException("" + id + " no existe en nuestra base de datos");
        }
    }

    @Override
    public Alumno findByDniAndNombres(String dni, String nombres) {
        Alumno alumno = new Alumno();
        if (dni == null || dni.equalsIgnoreCase("")) {
            if (nombres != null && !"".equalsIgnoreCase(dni)) {
                alumno = alumnoRepository.findAlumnoByNombres(nombres);
            }
        } else {
            if (nombres == null || "".equalsIgnoreCase(nombres)) {
                alumno = alumnoRepository.findAlumnoByDni(dni);
            } else {
                alumno = alumnoRepository.findAlumnoByDniAndNombres(dni, nombres);
            }
        }
        return alumno;
    }

    @Override
    public Alumno save(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public Alumno update(Alumno alumno, Integer id) {
        Alumno alumnoUpdate = new Alumno();
        if (id != null && id > 0) {
            Optional<Alumno> optionalAlumno = alumnoRepository.findById(id);
            if (optionalAlumno.isPresent()) {
                alumno.setId(id);
                alumnoUpdate = alumnoRepository.save(alumno);
            }
        } else {
            throw new ModelNotFoundException("" + id + " no existe en nuestra base de datos");
        }
        return alumnoUpdate;
    }

    @Override
    public void deleteById(Integer id) {
        boolean exists = alumnoRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("" + id + " no existe en nuestra base de datos");
        }
        alumnoRepository.deleteById(id);
    }

}
