package proyecto.escuela.escalab.ProyectoEscuelaEscalab.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Profesor;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.response.ExceptionResponse;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.ProfesorService;

import java.util.List;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @ApiOperation(value = "Obtener todos los Profesores",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Profesor")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, La lista de Profesores se obtiene correctamente.", response = Profesor.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class),
            @ApiResponse(code = 405, message = "No se encontraron Profesores en la base de datos", response = ExceptionResponse.class)})
    @GetMapping("/all")
    public @ResponseBody
    List<Profesor> findAll() {
        return profesorService.findAll();
    }

    @ApiOperation(value = "Obtener un Profesor por su Id",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Profesor")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se obtiene correctamente.", response = Profesor.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @GetMapping("/{id}")
    public @ResponseBody
    Profesor findById(@PathVariable("id") Integer id) {
        return profesorService.findById(id);
    }

    @ApiOperation(value = "Guardar un Profesor en la base de datos",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Profesor")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se guarda correctamente.", response = Profesor.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @PostMapping("/save")
    public @ResponseBody
    Profesor save(@RequestBody Profesor profesor) {
        return profesorService.save(profesor);
    }

    @ApiOperation(value = "Modificar un Profesor a traves de su Id",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Profesor")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se modifica correctamente.", response = Profesor.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @PutMapping("/update/{id}")
    public @ResponseBody
    Profesor update(@PathVariable("id") Integer id, @RequestBody Profesor profesor) {
        return profesorService.update(profesor, id);
    }

    @ApiOperation(value = "Eliminar un Profesor a traves de su Id",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Profesor")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se elimina correctamente.", response = Profesor.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        profesorService.deleteById(id);
    }


}
