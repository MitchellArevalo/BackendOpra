package ecommerce.modulesrol.controlador;

import ecommerce.ComandoRespuesta;
import ecommerce.modulesrol.comando.ComandoSolicitudActualizarModulosRol;
import ecommerce.modulesrol.comando.ComandoSolicitudCrearModuloRol;
import ecommerce.modulesrol.comando.ComandoSolicitudEliminarModuloDeUnRol;
import ecommerce.modulesrol.comando.manejador.ManejadorCrearModuloRol;
import ecommerce.modulesrol.comando.manejador.ManejadorEliminarModulosRol;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/modulosrol")
@Tag(name = "Controlador comando modulos rol")
public class ComandoControladorModulosRol {
    private final ManejadorCrearModuloRol manejadorCrearModuloRol;

    private final ManejadorEliminarModulosRol eliminarModulosRol;

    public ComandoControladorModulosRol(ManejadorCrearModuloRol manejadorCrearModuloRol, ManejadorEliminarModulosRol eliminarModulosRol) {
        this.manejadorCrearModuloRol = manejadorCrearModuloRol;
        this.eliminarModulosRol = eliminarModulosRol;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Crear employee", description = "Metodo para crear employee nuevo")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSolicitudCrearModuloRol comandoSolicitudCrearModuloRol){
        return this.manejadorCrearModuloRol.ejecutar(comandoSolicitudCrearModuloRol);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/rol/{id}")
    @Operation(summary = "Eliminar Employee", description = "Metodo para eliminar employee")
    public ResponseEntity<String> borrar(@PathVariable("id") Long idRol, @RequestBody ComandoSolicitudEliminarModuloDeUnRol moduloDeUnRol){
        return this.eliminarModulosRol.ejecutar(idRol, moduloDeUnRol.getIdModulo());
    }
}
