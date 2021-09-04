package proyecto.escuela.escalab.ProyectoEscuelaEscalab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.RegistroAcademico;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.exceptions.ModelNotFoundException;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.repository.RegistroAcademicoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroAcademicoServiceImpl implements RegistroAcademicoService{

    @Autowired
    private RegistroAcademicoRepository registroAcademicoRepository;

    @Override
    public List<RegistroAcademico> findAll() {
        List<RegistroAcademico> registroAcademicoList = registroAcademicoRepository.findAll();
        if (registroAcademicoList.isEmpty())
            throw new ModelNotFoundException("No existen Registros Académicos en la base de datos");
        return registroAcademicoRepository.findAll();
    }

    @Override
    public RegistroAcademico findById(Integer id) {
        Optional<RegistroAcademico> registroAcademicoOptional = registroAcademicoRepository.findById(id);
        if (registroAcademicoOptional.isPresent()){
            return registroAcademicoOptional.get();
        }else {
            throw new ModelNotFoundException("El Registro Académico no existe o la búsqueda es nula");
        }
    }

    @Override
    public RegistroAcademico save(RegistroAcademico registroAcademico) {
        return registroAcademicoRepository.save(registroAcademico);
    }

    @Override
    public RegistroAcademico update(RegistroAcademico registroAcademico, Integer id) {
        RegistroAcademico registroAcademicoUpdate = new RegistroAcademico();
        if (id != null && id > 0) {
            Optional<RegistroAcademico> optionalRegistroAcademico = registroAcademicoRepository.findById(id);
            if (optionalRegistroAcademico.isPresent()) {
                registroAcademico.setId(id);
                registroAcademicoUpdate = registroAcademicoRepository.save(registroAcademico);
            }
        } else {
            throw new ModelNotFoundException("El Registro Académico que ingresaste no existe");
        }
        return registroAcademicoUpdate;
    }

    @Override
    public void deleteById(Integer id) {
        boolean exists = registroAcademicoRepository.existsById(id);
        if (!exists) {
            throw new ModelNotFoundException("El Registro Académico que deseas eliminar no esta en la base de datos");
        }
        registroAcademicoRepository.deleteById(id);
    }
}
