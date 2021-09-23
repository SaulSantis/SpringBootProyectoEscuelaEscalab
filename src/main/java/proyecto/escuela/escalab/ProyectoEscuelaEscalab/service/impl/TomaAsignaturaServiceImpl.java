package proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.dto.AsignaturaDTO;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.dto.CursoDTO;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.dto.ProfesorDTO;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.dto.TomaAsignaturaDTO;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.TomaAsignatura;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.exceptions.ModelNotFoundException;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.repository.TomaAsignaturaRepository;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.TomaAsignaturaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TomaAsignaturaServiceImpl implements TomaAsignaturaService {

    @Autowired
    private TomaAsignaturaRepository tomaAsignaturaRepository;

    @Override
    public List<TomaAsignatura> findAll() {
        List<TomaAsignatura> tomaAsignaturaList = tomaAsignaturaRepository.findAll();
        if (tomaAsignaturaList.isEmpty())
            throw new ModelNotFoundException("No toma de asignaturas en la base de datos");
        return tomaAsignaturaRepository.findAll();
    }

    @Override
    public TomaAsignatura findById(Integer id) {
        Optional<TomaAsignatura> tomaAsignaturaOptionalOptional = tomaAsignaturaRepository.findById(id);
        if (tomaAsignaturaOptionalOptional.isPresent()){
            return tomaAsignaturaOptionalOptional.get();
        }else {
            throw new ModelNotFoundException("" + id + " no existe en nuestra base de datos");
        }
    }

    @Override
    public TomaAsignatura save(TomaAsignatura tomaAsignatura) {
        return tomaAsignaturaRepository.save(tomaAsignatura);
    }

    @Override
    public TomaAsignatura update(TomaAsignatura tomaAsignatura, Integer id) {
        TomaAsignatura tomaAsignaturaUpdate = new TomaAsignatura();
        if (id != null && id > 0) {
            Optional<TomaAsignatura> tomaAsignaturaOptional = tomaAsignaturaRepository.findById(id);
            if (tomaAsignaturaOptional.isPresent()) {
                tomaAsignatura.setId(id);
                tomaAsignaturaUpdate = tomaAsignaturaRepository.save(tomaAsignatura);
            }
        } else {
            throw new ModelNotFoundException("" + id + " no existe en nuestra base de datos");
        }
        return tomaAsignaturaUpdate;
    }

    @Override
    public void deleteById(Integer id) {
        boolean exists = tomaAsignaturaRepository.existsById(id);
        if (!exists) {
            throw new ModelNotFoundException("" + id + " no existe en nuestra base de datos");
        }
        tomaAsignaturaRepository.deleteById(id);
    }

    @Override
    public List<TomaAsignaturaDTO> findAllTomaAsignatura() {
        List<TomaAsignaturaDTO> response = new ArrayList<>();
        List<TomaAsignatura> tomaAsignaturas = tomaAsignaturaRepository.findAll();
        tomaAsignaturas.forEach(tomaAsignatura -> {
            TomaAsignaturaDTO tomaAsignaturaDTO = new TomaAsignaturaDTO();
            tomaAsignaturaDTO.setIdConsTomaAsignatura(tomaAsignatura.getId());
            CursoDTO cursoDTO =new CursoDTO();
            cursoDTO.setNombre(tomaAsignatura.getCurso().getNombre());
            cursoDTO.setJornada(tomaAsignatura.getCurso().getJornada());
            tomaAsignaturaDTO.setCursoDTO(cursoDTO);
            AsignaturaDTO asignaturaDTO = new AsignaturaDTO();
            asignaturaDTO.setNombre(tomaAsignatura.getAsignatura().getNombre());
            tomaAsignaturaDTO.setAsignaturaDTO(asignaturaDTO);
            ProfesorDTO profesorDTO = new ProfesorDTO();
            profesorDTO.setNombres(tomaAsignatura.getProfesor().getNombres());
            profesorDTO.setApellidos(tomaAsignatura.getProfesor().getApellidos());
            tomaAsignaturaDTO.setProfesorDTO(profesorDTO);
            response.add(tomaAsignaturaDTO);
        });
        return response;
    }
}
