package proyecto.escuela.escalab.ProyectoEscuelaEscalab.dto;

import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;

public class TomaAsignaturaDTO extends ResourceSupport implements Serializable {

    private Integer idConsTomaAsignatura;
    private CursoDTO cursoDTO;
    private AsignaturaDTO asignaturaDTO;
    private ProfesorDTO profesorDTO;

    public Integer getIdConsTomaAsignatura() {
        return idConsTomaAsignatura;
    }

    public void setIdConsTomaAsignatura(Integer idConsTomaAsignatura) {
        this.idConsTomaAsignatura = idConsTomaAsignatura;
    }

    public CursoDTO getCursoDTO() {
        return cursoDTO;
    }

    public void setCursoDTO(CursoDTO cursoDTO) {
        this.cursoDTO = cursoDTO;
    }

    public AsignaturaDTO getAsignaturaDTO() {
        return asignaturaDTO;
    }

    public void setAsignaturaDTO(AsignaturaDTO asignaturaDTO) { this.asignaturaDTO = asignaturaDTO;
    }

    public ProfesorDTO getProfesorDTO() {
        return profesorDTO;
    }

    public void setProfesorDTO(ProfesorDTO profesorDTO) {
        this.profesorDTO = profesorDTO;
    }
}
