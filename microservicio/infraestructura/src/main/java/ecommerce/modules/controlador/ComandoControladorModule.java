package ecommerce.modules.controlador;

import ecommerce.ComandoRespuesta;
import ecommerce.employee.comando.ComandoActualizarEmployee;
import ecommerce.module.comando.ComandoSolicitudActualizarModulo;
import ecommerce.module.comando.ComandoSolicitudCrearModulo;
import ecommerce.module.comando.manejador.ManejadorActualizarModulo;
import ecommerce.module.comando.manejador.ManejadorCrearModulo;
import ecommerce.module.comando.manejador.ManejadorEliminarModulo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/module")
@Tag(name = "Controlador comando modules")
public class ComandoControladorModule {
    private final ManejadorCrearModulo manejadorCrearModulo;
    private final ManejadorEliminarModulo manejadorEliminarModulo;
    private final ManejadorActualizarModulo manejadorActualizarModulo;

    public ComandoControladorModule(ManejadorCrearModulo manejadorCrearModulo, ManejadorEliminarModulo manejadorEliminarModulo, ManejadorActualizarModulo manejadorActualizarModulo) {
        this.manejadorCrearModulo = manejadorCrearModulo;
        this.manejadorEliminarModulo = manejadorEliminarModulo;
        this.manejadorActualizarModulo = manejadorActualizarModulo;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Crear employee", description = "Metodo para crear employee nuevo")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSolicitudCrearModulo comandoSolicitudCrearModulo){
        return this.manejadorCrearModulo.ejecutar(comandoSolicitudCrearModulo);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Employee", description = "Metodo para eliminar employee")
    public ResponseEntity<String> borrar(@PathVariable("id") Long id){
        return this.manejadorEliminarModulo.ejecutar(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Employee", description = "Metodo para actualizar employee")
    public ResponseEntity<String> actualizar(@RequestBody ComandoSolicitudActualizarModulo comandoSolicitudActualizarModulo, @PathVariable("id") Long id){
        return this.manejadorActualizarModulo.actualizar(comandoSolicitudActualizarModulo, id);
    }
}
