package ecommerce.roles.controlador;

import ecommerce.ComandoRespuesta;
import ecommerce.roles.comando.ComandoSolicitudCrearRol;
import ecommerce.roles.comando.manejador.ManejadorCrearRol;
import ecommerce.roles.comando.manejador.ManejadorEliminarRol;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rol")
@Tag(name = "Controlador comando rol")
public class ComandoControladorRol {
    private final ManejadorCrearRol manejadorCrearRol;
    private final ManejadorEliminarRol manejadorEliminarRol;

    public ComandoControladorRol(ManejadorCrearRol manejadorCrearRol, ManejadorEliminarRol manejadorEliminarRol) {
        this.manejadorCrearRol = manejadorCrearRol;
        this.manejadorEliminarRol = manejadorEliminarRol;

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Crear cliente", description = "Metodo para crear rol nuevo")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSolicitudCrearRol comandoSolicitudCrearRol ){
        return this.manejadorCrearRol.ejecutar(comandoSolicitudCrearRol);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Employee", description = "Metodo para eliminar product")
    public ResponseEntity<String> borrar(@PathVariable("id") Long id){
        return manejadorEliminarRol.ejecutar(id);
    }
}
