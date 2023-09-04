package ecommerce.employee.controlador;

import ecommerce.ComandoRespuesta;
import ecommerce.employee.comando.ComandoActualizarEmployee;
import ecommerce.employee.comando.ComandoSolicitudCrearEmployee;
import ecommerce.employee.comando.manejador.ManejadorActualizarEmployee;
import ecommerce.employee.comando.manejador.ManejadorCrearEmployee;
import ecommerce.employee.comando.manejador.ManejadorEliminarEmployee;
import ecommerce.infraestructura.error.ManejadorError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@Tag(name = "Controlador comando employee")
public class ComandoControladorEmployee extends ManejadorError {

    private final ManejadorCrearEmployee manejadorCrearEmployee;
    private final ManejadorEliminarEmployee manejadorEliminarEmployee;
    private final ManejadorActualizarEmployee manejadorActualizarEmployee;


    public ComandoControladorEmployee(ManejadorCrearEmployee manejadorCrearEmployee, ManejadorEliminarEmployee manejadorEliminarEmployee, ManejadorActualizarEmployee manejadorActualizarEmployee) {
        this.manejadorCrearEmployee = manejadorCrearEmployee;
        this.manejadorEliminarEmployee = manejadorEliminarEmployee;
        this.manejadorActualizarEmployee = manejadorActualizarEmployee;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Crear employee", description = "Metodo para crear employee nuevo")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSolicitudCrearEmployee comandoSolicitudCrearEmployee){
        return this.manejadorCrearEmployee.ejecutar(comandoSolicitudCrearEmployee);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Employee", description = "Metodo para eliminar employee")
    public ResponseEntity<String> borrar(@PathVariable("id") Long id){
        this.manejadorEliminarEmployee.eliminar(id);
        return ResponseEntity.ok("Employee was remove succesfully");
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Employee", description = "Metodo para actualizar employee")
    public ResponseEntity<String> actualizar(@RequestBody ComandoActualizarEmployee comandoActualizarEmployee, @PathVariable("id") Long id){
        try {
            this.manejadorActualizarEmployee.ejecutar(comandoActualizarEmployee, id);
            return ResponseEntity.ok("Employee was updated succesfully");
        }catch (Exception e){
            return new ResponseEntity<>("Error al actualizar el empleado \n" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
