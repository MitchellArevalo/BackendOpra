package ecommerce.employee.controlador;

import ecommerce.ComandoRespuesta;
import ecommerce.employee.comando.ComandoSolicitudCrearEmployee;
import ecommerce.employee.comando.manejador.ManejadorCrearEmployee;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@Tag(name = "Controlador comando employee")
public class ComandoControladorEmployee {

    private final ManejadorCrearEmployee manejadorCrearEmployee;

    public ComandoControladorEmployee(ManejadorCrearEmployee manejadorCrearEmployee) {
        this.manejadorCrearEmployee = manejadorCrearEmployee;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Crear employee", description = "Metodo para crear employee nuevo")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSolicitudCrearEmployee comandoSolicitudCrearEmployee){
        return this.manejadorCrearEmployee.ejecutar(comandoSolicitudCrearEmployee);
    }

}
