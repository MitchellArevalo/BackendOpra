package ecommerce.personas.comando.manejador;

import ecommerce.ComandoRespuesta;
import ecommerce.manejador.ManejadorComandoRespuesta;
import ecommerce.personas.comando.ComandoSolicitudCrearPersona;
import ecommerce.personas.comando.fabrica.GenerarSolicitudCrearPersona;
import ecommerce.personas.servicio.ServicioCrearPersona;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPersona implements ManejadorComandoRespuesta<ComandoSolicitudCrearPersona, ComandoRespuesta<Long>> {

    private final GenerarSolicitudCrearPersona generarSolicitudCrearPersona;

    private final ServicioCrearPersona servicioCrearPersona;

    public ManejadorCrearPersona(GenerarSolicitudCrearPersona generarSolicitudCrearPersona, ServicioCrearPersona servicioCrearPersona) {
        this.generarSolicitudCrearPersona = generarSolicitudCrearPersona;
        this.servicioCrearPersona = servicioCrearPersona;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudCrearPersona comandoSolicitudCrearPersona) {
        return new ComandoRespuesta<>(servicioCrearPersona.ejecutar(generarSolicitudCrearPersona.crear(comandoSolicitudCrearPersona)));
    }
}
