package proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Contenido;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.exceptions.ModelNotFoundException;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.repository.ContenidoRepository;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.ContenidoService;

import java.util.List;
import java.util.Optional;

@Service
public class ContenidoServiceImpl implements ContenidoService {

    @Autowired
    private ContenidoRepository contenidoRepository;

    @Override
    public List<Contenido> findAll() {
        List<Contenido> contenidoList = contenidoRepository.findAll();
        if (contenidoList.isEmpty())
            throw new ModelNotFoundException("No existen Contenidos en la base de datos");
        return contenidoRepository.findAll();
    }

    @Override
    public Contenido findById(Integer id) {
        Optional<Contenido> contenidoOptional = contenidoRepository.findById(id);
        if (contenidoOptional.isPresent()) {
            return contenidoOptional.get();
        } else {
            throw new ModelNotFoundException("" + id + " no existe en nuestra base de datos");
        }
    }

    @Override
    public Contenido save(Contenido contenido) {
        return contenidoRepository.save(contenido);
    }

    @Override
    public Contenido update(Contenido contenido, Integer id) {
        Contenido contenidoUpdate = new Contenido();
        if (id != null && id > 0) {
            Optional<Contenido> optionalContenido = contenidoRepository.findById(id);
            if (optionalContenido.isPresent()) {
                contenido.setId(id);
                contenidoUpdate = contenidoRepository.save(contenido);
            }
        } else {
            throw new ModelNotFoundException("" + id + " no existe en nuestra base de datos");
        }
        return contenidoUpdate;
    }

    @Override
    public void deleteById(Integer id) {
        boolean exists = contenidoRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("" + id + " no existe en nuestra base de datos");
        }
        contenidoRepository.deleteById(id);
    }
}
