package proyecto.escuela.escalab.ProyectoEscuelaEscalab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.FichaMedica;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.exceptions.ModelNotFoundException;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.repository.FichaMedicaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FichaMedicaServiceImpl implements FichaMedicaService {

    @Autowired
    private FichaMedicaRepository fichaMedicaRepository;

    @Override
    public List<FichaMedica> findAll() {
        List<FichaMedica> fichaMedicaList = fichaMedicaRepository.findAll();
        if (fichaMedicaList.isEmpty())
            throw new ModelNotFoundException("No existen Fichas Medicas en la base de datos");
        return fichaMedicaRepository.findAll();
    }

    @Override
    public FichaMedica findById(Integer id) {
        Optional<FichaMedica> fichaMedicaOptional = fichaMedicaRepository.findById(id);
        if (fichaMedicaOptional.isPresent()){
            return fichaMedicaOptional.get();
        }else {
            throw new ModelNotFoundException("" + id + " no existe en nuestra base de datos");
        }
    }

    @Override
    public FichaMedica save(FichaMedica fichaMedica) {
        return fichaMedicaRepository.save(fichaMedica);
    }

    @Override
    public FichaMedica update(FichaMedica fichaMedica, Integer id) {
        FichaMedica fichaMedicaUpdate = new FichaMedica();
        if (id != null && id > 0) {
            Optional<FichaMedica> optionalFichaMedica = fichaMedicaRepository.findById(id);
            if (optionalFichaMedica.isPresent()) {
                fichaMedica.setId(id);
                fichaMedicaUpdate = fichaMedicaRepository.save(fichaMedica);
            }
        } else {
            throw new ModelNotFoundException("" + id + " no existe en nuestra base de datos");
        }
        return fichaMedicaUpdate;
    }

    @Override
    public void deleteById(Integer id) {
        boolean exists = fichaMedicaRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("" + id + " no existe en nuestra base de datos");
        }
        fichaMedicaRepository.deleteById(id);
    }
}
