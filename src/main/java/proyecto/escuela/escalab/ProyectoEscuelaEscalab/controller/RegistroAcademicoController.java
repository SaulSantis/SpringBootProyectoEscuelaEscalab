package proyecto.escuela.escalab.ProyectoEscuelaEscalab.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity.RegistroAcademico;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.response.ExceptionResponse;
import proyecto.escuela.escalab.ProyectoEscuelaEscalab.service.RegistroAcademicoService;

import java.util.List;

@RestController
@RequestMapping("/registro_academico")
public class RegistroAcademicoController {

        @Autowired
        private RegistroAcademicoService registroAcademicoService;

        @ApiOperation(value = "Obtener todos los Registros Académicos",
                notes = "No necesita parámetros de entrada",
                response = List.class,
                responseContainer = "RegistroAcademico")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "OK, La lista de Registros Académicos se obtiene correctamente.", response = RegistroAcademico.class, responseContainer = "List"),
                @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
                @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class),
                @ApiResponse(code = 405, message = "No se encontraron Registros Académicos en la base de datos", response = ExceptionResponse.class)})
        @GetMapping("/all")
        public @ResponseBody
        List<RegistroAcademico> findAll() {
                return registroAcademicoService.findAll();
        }

        @ApiOperation(value = "Obtener un Registro Académico por su Id",
                notes = "No necesita parámetros de entrada",
                response = List.class,
                responseContainer = "RegistroAcademico")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "OK, el recurso se obtiene correctamente.", response = RegistroAcademico.class, responseContainer = "List"),
                @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
                @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
        @GetMapping("/{id}")
        public @ResponseBody
        RegistroAcademico findById(@PathVariable("id") Integer id) {
                return registroAcademicoService.findById(id);
        }

        @ApiOperation(value = "Guardar un Registro Académico en la base de datos",
                notes = "No necesita parámetros de entrada",
                response = List.class,
                responseContainer = "RegistroAcademico")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "OK, el Registro Académico se guarda correctamente.", response = RegistroAcademico.class, responseContainer = "List"),
                @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
                @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
        @PostMapping("/save")
        public @ResponseBody
        RegistroAcademico save(@RequestBody RegistroAcademico registroAcademico) {
            return registroAcademicoService.save(registroAcademico);
        }

        @ApiOperation(value = "Modificar un Registro Académico a traves de su Id",
                notes = "No necesita parámetros de entrada",
                response = List.class,
                responseContainer = "RegistroAcademico")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "OK, el recurso se modifica correctamente.", response = RegistroAcademico.class, responseContainer = "List"),
                @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
                @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
        @PutMapping("/update/{id}")
        public @ResponseBody
        RegistroAcademico update(@PathVariable("id") Integer id, @RequestBody RegistroAcademico registroAcademico) {
            return registroAcademicoService.update(registroAcademico, id);
        }

        @ApiOperation(value = "Eliminar un Registro Académico a traves de su Id",
                notes = "No necesita parámetros de entrada",
                response = List.class,
                responseContainer = "RegistroAcademico")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "OK, el recurso se elimina correctamente.", response = RegistroAcademico.class, responseContainer = "List"),
                @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
                @ApiResponse(code = 404, message = "No encontrado", response = ExceptionResponse.class)})
        @DeleteMapping("/delete/{id}")
        public void deleteById(@PathVariable("id") Integer id) {
                registroAcademicoService.deleteById(id);
        }
}
