package ecommerce.notifications.comando.manejador;

import ecommerce.ComandoRespuesta;
import ecommerce.manejador.ManejadorComandoRespuesta;
import ecommerce.notifications.comando.ComandoSolicitudCrearNotification;
import ecommerce.notifications.comando.fabrica.GenerarSolicitudCrearNotification;
import ecommerce.notifications.servicio.ServiciosNotifications;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearNotification implements ManejadorComandoRespuesta<ComandoSolicitudCrearNotification, ComandoRespuesta<Long>> {

    private final GenerarSolicitudCrearNotification generarSolicitudCrearNotification;
    private final ServiciosNotifications serviciosNotifications;

    public ManejadorCrearNotification(GenerarSolicitudCrearNotification generarSolicitudCrearNotification, ServiciosNotifications serviciosNotifications) {
        this.generarSolicitudCrearNotification = generarSolicitudCrearNotification;
        this.serviciosNotifications = serviciosNotifications;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudCrearNotification comando) {
        return new ComandoRespuesta<>(serviciosNotifications.crear(generarSolicitudCrearNotification.generate(comando)));
    }
}
