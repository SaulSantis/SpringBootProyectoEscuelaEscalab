package proyecto.escuela.escalab.ProyectoEscuelaEscalab.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.Service.ProfesorService;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Curso;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Profesor;

import java.util.List;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @GetMapping
    public @ResponseBody
    List<Profesor> findAll() {
        return profesorService.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Profesor findById(@PathVariable("id") Integer id) {
        return profesorService.findById(id);
    }

    @PostMapping("/save")
    public @ResponseBody
    Profesor save(@RequestBody Profesor profesor) {
        return profesorService.save(profesor);
    }

    @PutMapping("/update/{id}")
    public @ResponseBody
    Profesor update(@PathVariable("id") Integer id, @RequestBody Profesor profesor) {
        return profesorService.update(profesor, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        profesorService.deleteById(id);
    }



}
