package proyecto.escuela.escalab.ProyectoEscuelaEscalab.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Alumno;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.response.ExceptionResponse;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.AlumnoService;

import java.util.List;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @ApiOperation(value = "Obtener todos los Alumnos",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Alumno")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, La lista de Alumnos se obtiene correctamente.", response = Alumno.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class),
            @ApiResponse(code = 405, message = "No se encontraron Alumnos en la base de datos", response = ExceptionResponse.class)})
    @GetMapping("/all")
    public @ResponseBody
    List<Alumno> findAll() {
        return alumnoService.findAll();
    }

    @ApiOperation(value = "Obtener un Alumno por su Id",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Alumno")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se obtiene correctamente.", response = Alumno.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @GetMapping("/{id}")
    public @ResponseBody
    Alumno findById(@PathVariable("id") Integer id) {
        return alumnoService.findById(id);
    }

    @ApiOperation(value = "Obtener Dni y Nombre desde Alumno",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Alumno")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se obtiene correctamente.", response = Alumno.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @GetMapping("/dniAndNombre")
    public @ResponseBody
    Alumno findByDniAndNombres(@RequestParam (value = "dni", required = false)String dni,
                               @RequestParam(value = "nombres", required = false) String nombres){
        return alumnoService.findByDniAndNombres(dni,nombres);
    }

    @ApiOperation(value = "Guardar un Alumno en la base de datos",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Alumno")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se guarda correctamente.", response = Alumno.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @PostMapping("/save")
    public @ResponseBody
    Alumno save(@RequestBody Alumno alumno) {
        return alumnoService.save(alumno);
    }

    @ApiOperation(value = "Modificar un Alumno a traves de su Id",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Alumno")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se modifica correctamente.", response = Alumno.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @PutMapping("/update/{id}")
    public @ResponseBody
    Alumno update(@PathVariable("id") Integer id, @RequestBody Alumno alumno) {
        return alumnoService.update(alumno, id);
    }

    @ApiOperation(value = "Eliminar un Alumno a traves de su Id",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Alumno")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se elimina correctamente.", response = Alumno.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        alumnoService.deleteById(id);
    }
}
