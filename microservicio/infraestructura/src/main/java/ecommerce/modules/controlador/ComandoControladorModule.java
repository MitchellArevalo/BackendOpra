package ecommerce.modules.controlador;

import ecommerce.ComandoRespuesta;
import ecommerce.module.comando.ComandoSolicitudCrearModulo;
import ecommerce.module.comando.manejador.ManejadorCrearModulo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/module")
@Tag(name = "Controlador comando modules")
public class ComandoControladorModule {
    private final ManejadorCrearModulo manejadorCrearModulo;

    public ComandoControladorModule(ManejadorCrearModulo manejadorCrearModulo) {
        this.manejadorCrearModulo = manejadorCrearModulo;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Crear employee", description = "Metodo para crear employee nuevo")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSolicitudCrearModulo comandoSolicitudCrearModulo){
        return this.manejadorCrearModulo.ejecutar(comandoSolicitudCrearModulo);
    }
}
