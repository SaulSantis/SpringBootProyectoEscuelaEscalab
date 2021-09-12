package proyecto.escuela.escalab.ProyectoEscuelaEscalab.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Asignatura;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.response.ExceptionResponse;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.AsignaturaService;

import java.util.List;

@RestController
@RequestMapping("/asignatura")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    @ApiOperation(value = "Obtener todos las Asignatura",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Asignatura")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, La lista de Asignaturas se obtiene correctamente.", response = Asignatura.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class),
            @ApiResponse(code = 405, message = "No se encontraron Asignaturas en la base de datos", response = ExceptionResponse.class)})
    @GetMapping
    public @ResponseBody
    List<Asignatura> findAll() {
        return asignaturaService.findAll();
    }

    @ApiOperation(value = "Obtener una Asignatura por su Id",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Asignatura")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se obtiene correctamente.", response = Asignatura.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @GetMapping("/{id}")
    public @ResponseBody
    Asignatura findById(@PathVariable("id") Integer id) {
        return asignaturaService.findById(id);
    }

    @ApiOperation(value = "Obtener Nombre y Jornada desde Asignatura",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Asignatura")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se obtiene correctamente.", response = Asignatura.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @GetMapping("/busqueda")
    public @ResponseBody
    Asignatura findByNombreAndJornada(@RequestParam(value = "nombre", required = false) String nombre,
                                  @RequestParam(value = "jornada", required = false) String jornada) {
        return asignaturaService.findByNombreAndJornada(nombre, jornada);
    }

    @ApiOperation(value = "Guardar una Asignatura en la base de datos",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Asignatura")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se guarda correctamente.", response = Asignatura.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @PostMapping("/save")
    public @ResponseBody
    Asignatura save(@RequestBody Asignatura asignatura) {
        return asignaturaService.save(asignatura);
    }

    @ApiOperation(value = "Modificar una Asignatura a traves de su Id",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Asignatura")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se modifica correctamente.", response = Asignatura.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @PutMapping("/update/{id}")
    public @ResponseBody
    Asignatura update(@PathVariable("id") Integer id, @RequestBody Asignatura asignatura) {
        return asignaturaService.update(asignatura, id);
    }

    @ApiOperation(value = "Eliminar una Asignatura a traves de su Id",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Asignatura")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se elimina correctamente.", response = Asignatura.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        asignaturaService.deleteById(id);
    }


}
