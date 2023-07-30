package ecommerce.personas.controlador;

import ecommerce.ComandoRespuesta;
import ecommerce.personas.comando.ComandoSolicitudCrearPersona;
import ecommerce.personas.comando.manejador.ManejadorCrearPersona;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
@Tag(name = "Controlador comando persona")
public class ComandoControladorPersona {
    private final ManejadorCrearPersona manejadorCrearPersona;

    public ComandoControladorPersona(ManejadorCrearPersona manejadorCrearPersona) {
        this.manejadorCrearPersona = manejadorCrearPersona;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Crear cliente", description = "Metodo para crear persona nueva")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSolicitudCrearPersona comandoSolicitudCrearPersona){
        return this.manejadorCrearPersona.ejecutar(comandoSolicitudCrearPersona);
    }


}
