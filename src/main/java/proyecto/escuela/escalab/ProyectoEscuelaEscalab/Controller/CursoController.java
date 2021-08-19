package proyecto.escuela.escalab.ProyectoEscuelaEscalab.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.Service.CursoService;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Curso;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public @ResponseBody
    List<Curso> findAll() {
        return cursoService.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Curso findById(@PathVariable("id") Integer id) {
        return cursoService.findById(id);
    }

    @GetMapping("/nombre/{nombre}/jornada/{jornada}")
    public @ResponseBody
    Curso findByNombreAndJornada(@PathVariable("nombre") String nombre,
                                 @PathVariable("jornada") String jornada) {
        return cursoService.findByNombreAndJornada(nombre, jornada);
    }


    @GetMapping("/nombreAndJornada")
    public @ResponseBody
    Curso findByNombreAndJornada2(@RequestParam(value = "nombre", required = false) String nombre,
                                  @RequestParam(value = "jornada", required = false) String jornada) {
        return cursoService.findByNombreAndJornada(nombre, jornada);
    }

    @PostMapping
    public @ResponseBody
    Curso save(@RequestBody Curso curso) {
        return cursoService.save(curso);
    }

    @PutMapping("/{id}")
    public @ResponseBody Curso update(@PathVariable("id") Integer id, @RequestBody Curso curso) {
        return cursoService.update(curso, id);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody Curso delete(@PathVariable("id") Integer id, @RequestBody Curso curso) {
        return cursoService.deleteById(Curso curso, Integer id);
    }
}
