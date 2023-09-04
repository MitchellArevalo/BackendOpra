package ecommerce.notifications.comando.manejador;

import ecommerce.notifications.comando.ComandoSolicitudActualizarNotification;
import ecommerce.notifications.comando.fabrica.GenerarSolicitudActualizarNotificacion;
import ecommerce.notifications.servicio.ServiciosNotifications;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarNotificacion {
    private final GenerarSolicitudActualizarNotificacion actualizarNotificacion;
    private final ServiciosNotifications serviciosNotifications;

    public ManejadorActualizarNotificacion(GenerarSolicitudActualizarNotificacion actualizarNotificacion, ServiciosNotifications serviciosNotifications) {
        this.actualizarNotificacion = actualizarNotificacion;
        this.serviciosNotifications = serviciosNotifications;
    }

    public void ejecutar(ComandoSolicitudActualizarNotification comandoSolicitudActualizarNotification, Long id){
        serviciosNotifications.update(actualizarNotificacion.generate(comandoSolicitudActualizarNotification), id);
    }
}
