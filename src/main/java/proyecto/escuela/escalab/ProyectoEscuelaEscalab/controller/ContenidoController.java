package proyecto.escuela.escalab.ProyectoEscuelaEscalab.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Contenido;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.response.ExceptionResponse;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.ContenidoService;

import java.util.List;

@RestController
@RequestMapping("/contenido")
public class ContenidoController {

    @Autowired
    private ContenidoService contenidoService;

    @ApiOperation(value = "Obtener todos los Contenidos",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Contenido")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, La lista de Contenido se obtiene correctamente.", response = Contenido.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class),
            @ApiResponse(code = 405, message = "No se encontró Contenido en la base de datos", response = ExceptionResponse.class)})
    @GetMapping("/all")
    public @ResponseBody
    List<Contenido> findAll() {
        return contenidoService.findAll();
    }

    @ApiOperation(value = "Obtener un Contenido por su Id",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Contenido")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se obtiene correctamente.", response = Contenido.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @GetMapping("/{id}")
    public @ResponseBody
    Contenido findById(@PathVariable("id") Integer id) {
        return contenidoService.findById(id);
    }

    @ApiOperation(value = "Guardar un Contenido en la base de datos",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Contenido")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se guarda correctamente.", response = Contenido.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @PostMapping("/save")
    public @ResponseBody
    Contenido save(@RequestBody Contenido contenido) {
        return contenidoService.save(contenido);
    }

    @ApiOperation(value = "Modificar un Contenido a traves de su Id",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Contenido")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se modifica correctamente.", response = Contenido.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @PutMapping("/update/{id}")
    public @ResponseBody
    Contenido update(@PathVariable("id") Integer id, @RequestBody Contenido contenido) {
        return contenidoService.update(contenido, id);
    }

    @ApiOperation(value = "Eliminar un Contenido a traves de su Id",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Contenido")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se elimina correctamente.", response = Contenido.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        contenidoService.deleteById(id);
    }

}
