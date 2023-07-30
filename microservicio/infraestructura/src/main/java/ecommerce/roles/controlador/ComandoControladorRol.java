package ecommerce.roles.controlador;

import ecommerce.ComandoRespuesta;
import ecommerce.roles.comando.ComandoSolicitudCrearRol;
import ecommerce.roles.comando.manejador.ManejadorCrearRol;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rol")
@Tag(name = "Controlador comando rol")
public class ComandoControladorRol {
    private final ManejadorCrearRol manejadorCrearRol;

    public ComandoControladorRol(ManejadorCrearRol manejadorCrearRol) {
        this.manejadorCrearRol = manejadorCrearRol;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Crear cliente", description = "Metodo para crear rol nuevo")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSolicitudCrearRol comandoSolicitudCrearRol ){
        return this.manejadorCrearRol.ejecutar(comandoSolicitudCrearRol);
    }
}
