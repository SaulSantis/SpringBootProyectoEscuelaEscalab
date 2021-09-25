package proyecto.escuela.escalab.ProyectoEscuelaEscalab.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.Apoderado;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.response.ExceptionResponse;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.ApoderadoService;

import java.util.List;

@RestController
@RequestMapping("/apoderado")
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
public class ApoderadoController {

    @Autowired
    private ApoderadoService apoderadoService;

    @ApiOperation(value = "Obtener todos los Apoderados",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Apoderado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, La lista de Apoderados se obtiene correctamente.", response = Apoderado.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class),
            @ApiResponse(code = 405, message = "No se encontraron Apoderados en la base de datos", response = ExceptionResponse.class)})
    @GetMapping("/all")
    public @ResponseBody
    List<Apoderado> findAll() {
        return apoderadoService.findAll();
    }

    @ApiOperation(value = "Obtener un Apoderado por su Id",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Apoderado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se obtiene correctamente.", response = Apoderado.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @GetMapping("/{id}")
    public @ResponseBody
    Apoderado findById(@PathVariable("id") Integer id) {
        return apoderadoService.findById(id);
    }

    @ApiOperation(value = "Obtener Dni y Nombre desde Apoderado",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Apoderado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se obtiene correctamente.", response = Apoderado.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @GetMapping("/dniAndNombre")
    public @ResponseBody
    Apoderado findByDniAndNombres(@RequestParam(value = "dni", required = false) String dni,
                                  @RequestParam(value = "nombres", required = false) String nombres) {
        return apoderadoService.findByDniAndNombres(dni, nombres);
    }

    @ApiOperation(value = "Guardar un Apoderado en la base de datos",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Apoderado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se guarda correctamente.", response = Apoderado.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @PostMapping("/save")
    public @ResponseBody
    Apoderado save(@RequestBody Apoderado apoderado) {
        return apoderadoService.save(apoderado);
    }

    @ApiOperation(value = "Modificar un Apoderado a traves de su Id",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Apoderado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se modifica correctamente.", response = Apoderado.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @PutMapping("/update/{id}")
    public @ResponseBody
    Apoderado update(@PathVariable("id") Integer id, @RequestBody Apoderado apoderado) {
        return apoderadoService.update(apoderado, id);
    }

    @ApiOperation(value = "Eliminar un Apoderado a traves de su Id",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "Apoderado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se elimina correctamente.", response = Apoderado.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        apoderadoService.deleteById(id);
    }
}
