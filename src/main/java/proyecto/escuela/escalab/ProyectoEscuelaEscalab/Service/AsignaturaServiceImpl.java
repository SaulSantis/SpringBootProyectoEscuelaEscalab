package proyecto.escuela.escalab.ProyectoEscuelaEscalab.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.Repository.AsignaturaRepository;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.Repository.CursoRepository;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Asignatura;

import java.util.List;

@Service
public class AsignaturaServiceImpl implements AsignaturaService{

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Override
    public List<Asignatura> findAll() {
        return asignaturaRepository.findAll();
    }

    @Override
    public Asignatura save(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }
}
