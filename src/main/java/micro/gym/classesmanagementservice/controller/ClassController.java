package micro.gym.classesmanagementservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import micro.gym.classesmanagementservice.model.Class;
import micro.gym.classesmanagementservice.service.ClassService;

@RestController
@RequestMapping("/classes")
@Tag(name = "Classes", description = "Gestión de clases del gimnasio")
public class ClassController {
 
    @Autowired
    private ClassService classService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MEMBER', 'TRAINER')")
    @Operation(summary = "Obtener todas las clases", description = "Obtiene el listado completo de todas las clases disponibles")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Clases obtenidas exitosamente",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Class.class))),
        @ApiResponse(responseCode = "401", description = "No autenticado"),
        @ApiResponse(responseCode = "403", description = "No tiene permisos")
    })
    public List<Class> getAllClasses() {
        return classService.getAllClasses();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('TRAINER')")
    @Operation(summary = "Crear una nueva clase", description = "Crea una nueva clase en el gimnasio. Solo ADMIN y TRAINER pueden crear")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Clase creada exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos"),
        @ApiResponse(responseCode = "401", description = "No autenticado"),
        @ApiResponse(responseCode = "403", description = "No tiene permisos")
    })
    public void createClass(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Datos de la clase a crear",
            required = true,
            content = @Content(mediaType = "application/json",
                examples = @ExampleObject(value = "{ \"name\": \"Yoga\", \"description\": \"Clase de yoga relajante\", \"trainerId\": \"T001\", \"schedule\": \"Lunes 10:00\", \"capacity\": 20 }")))
        @RequestBody Class gymClass) {
        classService.programClass(gymClass.getTrainerId(),gymClass);
    }
}


