package proyecto.escuela.escalab.ProyectoEscuelaEscalab.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.FichaMedica;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.response.ExceptionResponse;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.FichaMedicaService;

import java.util.List;

@RestController
@RequestMapping("/ficha_medica")
public class FichaMedicaController {

    @Autowired
    private FichaMedicaService fichaMedicaService;

    @ApiOperation(value = "Obtener todos las Fichas Médicas",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "FichaMedica")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, La lista de Fichas Médicas se obtiene correctamente.", response = FichaMedica.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class),
            @ApiResponse(code = 405, message = "No se encontraron Fichas Médicas en la base de datos", response = ExceptionResponse.class)})
    @GetMapping("/all")
    public @ResponseBody
    List<FichaMedica> findAll() {
        return fichaMedicaService.findAll();
    }

    @ApiOperation(value = "Obtener una Ficha Médica por su Id",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "FichaMedica")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se obtiene correctamente.", response = FichaMedica.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @GetMapping("/{id}")
    public @ResponseBody
    FichaMedica findById(@PathVariable("id") Integer id) {
        return fichaMedicaService.findById(id);
    }

    @ApiOperation(value = "Guardar una Ficha Médica en la base de datos",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "FichaMedica")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se guarda correctamente.", response = FichaMedica.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @PostMapping("/save")
    public @ResponseBody
    FichaMedica save(@RequestBody FichaMedica fichaMedica) {
        return fichaMedicaService.save(fichaMedica);
    }

    @ApiOperation(value = "Modificar una Ficha Médica a traves de su Id",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "FichaMedica")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se modifica correctamente.", response = FichaMedica.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @PutMapping("/update/{id}")
    public @ResponseBody
    FichaMedica update(@PathVariable("id") Integer id, @RequestBody FichaMedica fichaMedica) {
        return fichaMedicaService.update(fichaMedica, id);
    }

    @ApiOperation(value = "Eliminar una Ficha Médica a traves de su Id",
            notes = "No necesita parámetros de entrada",
            response = List.class,
            responseContainer = "FichaMedica")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK, el recurso se elimina correctamente.", response = FichaMedica.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        fichaMedicaService.deleteById(id);
    }

}
