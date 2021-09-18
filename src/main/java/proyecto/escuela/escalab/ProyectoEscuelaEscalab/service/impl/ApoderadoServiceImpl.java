package proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Apoderado;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.exceptions.ModelNotFoundException;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.repository.ApoderadoRepository;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.ApoderadoService;

import java.util.List;
import java.util.Optional;

@Service
public class ApoderadoServiceImpl implements ApoderadoService {

    @Autowired
    private ApoderadoRepository apoderadoRepository;

    @Override
    public List<Apoderado> findAll() {
        List<Apoderado> apoderadoList = apoderadoRepository.findAll();
        if (apoderadoList.isEmpty())
            throw new ModelNotFoundException("No existen Apoderados en la base de datos");
        return apoderadoRepository.findAll();
    }

    @Override
    public Apoderado findById(Integer id) {
        Optional<Apoderado> apoderadoOptional = apoderadoRepository.findById(id);
        if (apoderadoOptional.isPresent()){
            return apoderadoOptional.get();
        }else {
            throw new ModelNotFoundException("" + id + " no existe en nuestra base de datos");
        }
    }

    @Override
    public Apoderado findByDniAndNombres(String dni, String nombres) {
        Apoderado apoderado = new Apoderado();
        if (dni == null || dni.equalsIgnoreCase("")) {
            if (nombres != null && !"".equalsIgnoreCase(dni)) {
                apoderado = apoderadoRepository.findApoderadoByNombres(nombres);
            }
        } else {
            if (nombres == null || "".equalsIgnoreCase(nombres)) {
                apoderado = apoderadoRepository.findApoderadoByDni(dni);
            } else {
                apoderado = apoderadoRepository.findApoderadoByDniAndNombres(dni, nombres);
            }
        }
        return apoderado;
    }

    @Override
    public Apoderado save(Apoderado apoderado) {
        return apoderadoRepository.save(apoderado);
    }

    @Override
    public Apoderado update(Apoderado apoderado, Integer id) {
        Apoderado apoderadoUpdate = new Apoderado();
        if (id != null && id > 0) {
            Optional<Apoderado> optionalApoderado = apoderadoRepository.findById(id);
            if (optionalApoderado.isPresent()) {
                apoderado.setId(id);
                apoderadoUpdate = apoderadoRepository.save(apoderado);
            }
        } else {
            throw new ModelNotFoundException("" + id + " no existe en nuestra base de datos");
        }
        return apoderadoUpdate;
    }

    @Override
    public void deleteById(Integer id) {
        boolean exists = apoderadoRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("" + id + " no existe en nuestra base de datos");
        }
        apoderadoRepository.deleteById(id);
    }
}
