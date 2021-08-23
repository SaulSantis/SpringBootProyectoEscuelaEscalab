package proyecto.escuela.escalab.ProyectoEscuelaEscalab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Aprendizaje;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.AprendizajeService;

import java.util.List;

@RestController
@RequestMapping("/aprendizaje")
public class AprendizajeController {

    @Autowired
    private AprendizajeService aprendizajeService;

    @GetMapping
    public @ResponseBody
    List<Aprendizaje> findAll() {
        return aprendizajeService.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Aprendizaje findById(@PathVariable("id") Integer id) {
        return aprendizajeService.findById(id);
    }

    @PostMapping("/save")
    public @ResponseBody
    Aprendizaje save(@RequestBody Aprendizaje aprendizaje) {
        return aprendizajeService.save(aprendizaje);
    }

    @PutMapping("/update/{id}")
    public @ResponseBody
    Aprendizaje update(@PathVariable("id") Integer id, @RequestBody Aprendizaje aprendizaje) {
        return aprendizajeService.update(aprendizaje, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        aprendizajeService.deleteById(id);
    }


}
