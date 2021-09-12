package proyecto.escuela.escalab.ProyectoEscuelaEscalab.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.TomaAsignatura;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.response.ExceptionResponse;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.TomaAsignaturaService;

import java.util.List;

@RestController
@RequestMapping("/toma_asignatura")
public class TomaAsignaturaController {

    @Autowired
    private TomaAsignaturaService tomaAsignaturaService;

    @ApiOperation(value = "Obtener todos las Tomas de Asignatura",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "TomaAsignatura")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, La lista de Tomas de Asignatura se obtiene correctamente.", response = TomaAsignatura.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class),
            @ApiResponse(code = 405, message = "No se encontraron Tomas de Asignatura en la base de datos", response = ExceptionResponse.class)})
    @GetMapping
    public @ResponseBody
    List<TomaAsignatura> findAll() {
        return tomaAsignaturaService.findAll();
    }

    @ApiOperation(value = "Obtener Tomas de Asignatura por su Id",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "TomaAsignatura")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se obtiene correctamente.", response = TomaAsignatura.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})

    @GetMapping("/{id}")
    public @ResponseBody
    TomaAsignatura findById(@PathVariable("id") Integer id) {
        return tomaAsignaturaService.findById(id);
    }

    @ApiOperation(value = "Guardar Tomas de Asignatura en la base de datos",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "TomaAsignatura")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se guarda correctamente.", response = TomaAsignatura.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})

    @PostMapping("/save")
    public @ResponseBody
    TomaAsignatura save(@RequestBody TomaAsignatura tomaAsignatura) {
        return tomaAsignaturaService.save(tomaAsignatura);
    }

    @ApiOperation(value = "Modificar una Toma de Asignatura traves de su Id",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "TomaAsignatura")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se modifica correctamente.", response = TomaAsignatura.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @PutMapping("/update/{id}")
    public @ResponseBody
    TomaAsignatura update(@PathVariable("id") Integer id, @RequestBody TomaAsignatura tomaAsignatura) {
        return tomaAsignaturaService.update(tomaAsignatura, id);
    }

    @ApiOperation(value = "Eliminar una Toma de Asignatura a traves de su Id",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "TomaAsignatura")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se elimina correctamente.", response = TomaAsignatura.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        tomaAsignaturaService.deleteById(id);
    }

}
