package proyecto.escuela.escalab.ProyectoEscuelaEscalab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Aprendizaje;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.repository.AprendizajeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AprendizajeServiceImpl implements AprendizajeService{

    @Autowired
    private AprendizajeRepository aprendizajeRepository;

    @Override
    public List<Aprendizaje> findAll() {
        return aprendizajeRepository.findAll();
    }

    @Override
    public Aprendizaje findById(Integer id) {
        Optional<Aprendizaje> aprendizajeOptional = aprendizajeRepository.findById(id);
        return aprendizajeOptional.orElseGet(Aprendizaje::new);
    }

    @Override
    public Aprendizaje save(Aprendizaje aprendizaje) {
        return aprendizajeRepository.save(aprendizaje);
    }

    @Override
    public Aprendizaje update(Aprendizaje aprendizaje, Integer id) {
            Aprendizaje aprendizajeUpdate = new Aprendizaje();
            if (id != null && id > 0) {
                Optional<Aprendizaje> optionalAprendizaje = aprendizajeRepository.findById(id);
                if (optionalAprendizaje.isPresent()) {
                    aprendizaje.setId(id);
                    aprendizajeUpdate = aprendizajeRepository.save(aprendizaje);
                }
            } else {

            }
            return aprendizajeUpdate;
        }

    @Override
    public void deleteById(Integer id) {
        boolean exists = aprendizajeRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Aprendizaje " + id + " no existe en nuestra base de datos");
        }
        aprendizajeRepository.deleteById(id);
    }
}
