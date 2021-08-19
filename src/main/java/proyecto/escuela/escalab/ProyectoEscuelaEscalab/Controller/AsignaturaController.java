package proyecto.escuela.escalab.ProyectoEscuelaEscalab.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.Service.AsignaturaService;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Asignatura;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Curso;

import java.util.List;

@RestController
@RequestMapping("/asignatura")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping
    public @ResponseBody
    List<Asignatura> findAll() {
        return asignaturaService.findAll();
    }

    @PostMapping
    public @ResponseBody
    Asignatura save(@RequestBody Asignatura asignatura) {
        return asignaturaService.save(asignatura);
    }



}
