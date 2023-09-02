package ecommerce.employee.controlador;

import ecommerce.ComandoRespuesta;
import ecommerce.employee.comando.ComandoSolicitudCrearEmployee;
import ecommerce.employee.comando.manejador.ManejadorCrearEmployee;
import ecommerce.employee.comando.manejador.ManejadorEliminarEmployee;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@Tag(name = "Controlador comando employee")
public class ComandoControladorEmployee {

    private final ManejadorCrearEmployee manejadorCrearEmployee;
    private final ManejadorEliminarEmployee manejadorEliminarEmployee;

    public ComandoControladorEmployee(ManejadorCrearEmployee manejadorCrearEmployee, ManejadorEliminarEmployee manejadorEliminarEmployee) {
        this.manejadorCrearEmployee = manejadorCrearEmployee;
        this.manejadorEliminarEmployee = manejadorEliminarEmployee;
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

}
