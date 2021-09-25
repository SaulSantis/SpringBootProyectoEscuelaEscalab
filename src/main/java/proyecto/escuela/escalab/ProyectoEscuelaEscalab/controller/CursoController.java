package proyecto.escuela.escalab.ProyectoEscuelaEscalab.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Curso;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.response.ExceptionResponse;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.CursoService;

import java.util.List;

@RestController
@RequestMapping("/curso")
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @ApiOperation(value = "Obtener todos los cursos",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Curso")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, La lista de cursos se obtiene correctamente.", response = Curso.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class),
            @ApiResponse(code = 405, message = "No se encontraron Cursos en la base de datos", response = ExceptionResponse.class)})
    @GetMapping("/all")
    public @ResponseBody
    List<Curso> findAll() {
        return cursoService.findAll();
    }

    @ApiOperation(value = "Obtener un Curso por su Id",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Curso")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se obtiene correctamente.", response = Curso.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @GetMapping("/{id}")
    public @ResponseBody
    Curso findById(@PathVariable("id") Integer id) {
        return cursoService.findById(id);
    }

    @ApiOperation(value = "Obtener Nombre y Jornada desde Curso",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Curso")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se obtiene correctamente.", response = Curso.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @GetMapping("/nombreAndJornada")
    public @ResponseBody
    Curso findByNombreAndJornada(@RequestParam(value = "nombre", required = false) String nombre,
                                 @RequestParam(value = "jornada", required = false) String jornada) {
        return cursoService.findByNombreAndJornada(nombre, jornada);
    }

    @ApiOperation(value = "Guardar un Curso en la base de datos",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Curso")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se guarda correctamente.", response = Curso.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @PostMapping("/save")
    public @ResponseBody
    Curso save(@RequestBody Curso curso) {
        return cursoService.save(curso);
    }

    @ApiOperation(value = "Modificar un Curso a traves de su Id",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Curso")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se modifica correctamente.", response = Curso.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @PutMapping("/update/{id}")
    public @ResponseBody
    Curso update(@PathVariable("id") Integer id, @RequestBody Curso curso) {
        return cursoService.update(curso, id);
    }

    @ApiOperation(value = "Eliminar un Curso a traves de su Id",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Curso")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se elimina correctamente.", response = Curso.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        cursoService.deleteById(id);
    }

}
