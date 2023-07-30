package ecommerce.roles.comando.manejador;

import ecommerce.ComandoRespuesta;
import ecommerce.manejador.ManejadorComandoRespuesta;
import ecommerce.roles.comando.ComandoSolicitudCrearRol;
import ecommerce.roles.comando.fabrica.GenerarSolicitudCrearRol;
import ecommerce.roles.servicio.ServicioCrearRol;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearRol implements ManejadorComandoRespuesta<ComandoSolicitudCrearRol, ComandoRespuesta<Long>> {
    private final ServicioCrearRol servicioCrearRol;
    private final GenerarSolicitudCrearRol generarSolicitudCrearRol;

    public ManejadorCrearRol(ServicioCrearRol servicioCrearRol, GenerarSolicitudCrearRol generarSolicitudCrearRol) {
        this.servicioCrearRol = servicioCrearRol;
        this.generarSolicitudCrearRol = generarSolicitudCrearRol;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudCrearRol comandoSolicitudCrearRol) {
        return new ComandoRespuesta<>(servicioCrearRol.ejecutar(generarSolicitudCrearRol.crear(comandoSolicitudCrearRol)));
    }
}
