package ecommerce.modulesrol.controlador;

import ecommerce.ComandoRespuesta;
import ecommerce.modulesrol.comando.ComandoSolicitudCrearModuloRol;
import ecommerce.modulesrol.comando.manejador.ManejadorCrearModuloRol;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/modulosrol")
@Tag(name = "Controlador comando modulos rol")
public class ComandoControladorModulosRol {
    private final ManejadorCrearModuloRol manejadorCrearModuloRol;

    public ComandoControladorModulosRol(ManejadorCrearModuloRol manejadorCrearModuloRol) {
        this.manejadorCrearModuloRol = manejadorCrearModuloRol;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Crear employee", description = "Metodo para crear employee nuevo")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSolicitudCrearModuloRol comandoSolicitudCrearModuloRol){
        return this.manejadorCrearModuloRol.ejecutar(comandoSolicitudCrearModuloRol);
    }
}
