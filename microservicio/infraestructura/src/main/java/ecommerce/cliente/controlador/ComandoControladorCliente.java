package ecommerce.cliente.controlador;

import ecommerce.ComandoRespuesta;
import ecommerce.cliente.comando.ComandoSolicitudActualizarCliente;
import ecommerce.cliente.comando.ComandoSolicitudAutenticarCliente;
import ecommerce.cliente.comando.ComandoSolicitudCrearCliente;
import ecommerce.cliente.comando.manejador.ManejadorActualizarCliente;
import ecommerce.cliente.comando.manejador.ManejadorCrearCliente;
import ecommerce.cliente.comando.manejador.ManejadorEliminarCliente;
import ecommerce.cliente.comando.manejador.ManejadorLoginCliente;
import ecommerce.cliente.modelo.entidad.Cliente;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
@Tag(name = "Controlador comando cliente")
public class ComandoControladorCliente {

    private final ManejadorCrearCliente manejadorCrearCliente;
    private final ManejadorActualizarCliente manejadorActualizarCliente;
    private final ManejadorEliminarCliente manejadorEliminarCliente;
    private final ManejadorLoginCliente manejadorLoginCliente;

    public ComandoControladorCliente(ManejadorCrearCliente manejadorCrearCliente, ManejadorActualizarCliente manejadorActualizarCliente, ManejadorEliminarCliente manejadorEliminarCliente, ManejadorLoginCliente manejadorLoginCliente) {
        this.manejadorCrearCliente = manejadorCrearCliente;
        this.manejadorActualizarCliente = manejadorActualizarCliente;
        this.manejadorEliminarCliente = manejadorEliminarCliente;
        this.manejadorLoginCliente = manejadorLoginCliente;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Crear cliente", description = "Metodo para crear cliente nuevo")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSolicitudCrearCliente comandoSolicitudCrearCliente){
        return this.manejadorCrearCliente.ejecutar(comandoSolicitudCrearCliente);
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Cliente", description = "Metodo para eliminar Cliente")
    public ResponseEntity<String> borrar(@PathVariable("id") Long id){
        return this.manejadorEliminarCliente.ejecutar(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Cliente", description = "Metodo para actualizar Cliente")
    public ResponseEntity<String> actualizar(@RequestBody ComandoSolicitudActualizarCliente comandoSolicitudActualizarCliente, @PathVariable("id") Long id){
        return this.manejadorActualizarCliente.actualizar(comandoSolicitudActualizarCliente, id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/login")
    @Operation(summary = " cliente", description = "Metodo para crear cliente nuevo")
    public ResponseEntity<Cliente> autenticar(@RequestBody ComandoSolicitudAutenticarCliente comandoSolicitudAutenticarCliente){
        return this.manejadorLoginCliente.ejecutar(comandoSolicitudAutenticarCliente);
    }

}
