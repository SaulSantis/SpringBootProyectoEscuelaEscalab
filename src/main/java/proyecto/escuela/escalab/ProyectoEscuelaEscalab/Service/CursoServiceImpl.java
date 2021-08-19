package proyecto.escuela.escalab.ProyectoEscuelaEscalab.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.Repository.CursoRepository;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Curso;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso findById(Integer id) {
        Optional<Curso> cursoOptional = cursoRepository.findById(id);
        return cursoOptional.orElseGet(Curso::new);
    }

    @Override
    public Curso findByNombreAndJornada(String nombre, String jornada) {
        Curso curso = new Curso();
        if (nombre == null || nombre.equalsIgnoreCase("")) {
            if (jornada != null && !"".equalsIgnoreCase(nombre)) {
                curso = cursoRepository.findCursoByJornada(jornada);
            }
        } else {
            if (jornada == null || "".equalsIgnoreCase(jornada)) {
                curso = cursoRepository.findCursoByNombre(nombre);
            } else {
                curso = cursoRepository.findCursoByNombreAndJornada(nombre, jornada);
            }
        }
        return curso;
    }

    @Override
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso update(Curso curso, Integer id) {
        Curso cupdate = new Curso();
        if (id != null && id > 0) {
            Optional<Curso> optionalCurso = cursoRepository.findById(id);
            if (optionalCurso.isPresent()) {
                curso.setId(id);
                cupdate = cursoRepository.save(curso);
            }
        } else {

        }
        return cupdate;
    }

    @Override
    public Curso delete(Curso curso, Integer id) {
        Curso cdelete = new Curso();
        if (id != null && id > 0) {
            Optional<Curso> optCurso = cursoRepository.deleteById(id);
            if (optCurso.isPresent()) {
                curso.setId(id);
                cdelete = cursoRepository.deleteById(curso);
            }
        } else {

        }
        return cdelete;
    }
}
