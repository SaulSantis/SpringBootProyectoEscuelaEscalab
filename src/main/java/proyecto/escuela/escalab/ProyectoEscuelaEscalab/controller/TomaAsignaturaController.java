package proyecto.escuela.escalab.ProyectoEscuelaEscalab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.TomaAsignatura;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.TomaAsignaturaService;

import java.util.List;

@RestController
@RequestMapping("/toma_asignatura")
public class TomaAsignaturaController {

    @Autowired
    private TomaAsignaturaService tomaAsignaturaService;

    @GetMapping
    public @ResponseBody
    List<TomaAsignatura> findAll() {
        return tomaAsignaturaService.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    TomaAsignatura findById(@PathVariable("id") Integer id) {
        return tomaAsignaturaService.findById(id);
    }

    @PostMapping("/save")
    public @ResponseBody
    TomaAsignatura save(@RequestBody TomaAsignatura tomaAsignatura) {
        return tomaAsignaturaService.save(tomaAsignatura);
    }

    @PutMapping("/update/{id}")
    public @ResponseBody
    TomaAsignatura update(@PathVariable("id") Integer id, @RequestBody TomaAsignatura tomaAsignatura) {
        return tomaAsignaturaService.update(tomaAsignatura, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        tomaAsignaturaService.deleteById(id);
    }

}
