package ecommerce.notifications.controlador;

import ecommerce.ComandoRespuesta;
import ecommerce.employee.comando.ComandoActualizarEmployee;
import ecommerce.notifications.comando.ComandoSolicitudActualizarNotification;
import ecommerce.notifications.comando.ComandoSolicitudCrearNotification;
import ecommerce.notifications.comando.manejador.ManejadorActualizarNotificacion;
import ecommerce.notifications.comando.manejador.ManejadorCrearNotification;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
@Tag(name = "Controlador comando notifications")
public class ComandoControladorNotifications {
    private final ManejadorCrearNotification manejadorCrearNotification;
    private final ManejadorActualizarNotificacion manejadorActualizarNotificacion;

    public ComandoControladorNotifications(ManejadorCrearNotification manejadorCrearNotification, ManejadorActualizarNotificacion manejadorActualizarNotificacion) {
        this.manejadorCrearNotification = manejadorCrearNotification;
        this.manejadorActualizarNotificacion = manejadorActualizarNotificacion;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Crear notification", description = "Metodo para crear notification nueva")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSolicitudCrearNotification comandoSolicitudCrearNotification){
        return this.manejadorCrearNotification.ejecutar(comandoSolicitudCrearNotification);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Notification", description = "Metodo para actualizar notification")
    public ResponseEntity<String> actualizar(@RequestBody ComandoSolicitudActualizarNotification comandoSolicitudActualizarNotification, @PathVariable("id") Long id){
        try {
            this.manejadorActualizarNotificacion.ejecutar(comandoSolicitudActualizarNotification, id);
            return ResponseEntity.ok("Notification was updated succesfully");
        }catch (Exception e){
            return new ResponseEntity<>("Error al actualizar el empleado \n" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
