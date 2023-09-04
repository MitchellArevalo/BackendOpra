package ecommerce.module.comando.manejador;

import ecommerce.ComandoRespuesta;
import ecommerce.manejador.ManejadorComandoRespuesta;
import ecommerce.module.comando.ComandoSolicitudCrearModulo;
import ecommerce.module.comando.fabrica.GenerarSolicitudCrearModulo;
import ecommerce.modules.servicios.ServicioCrearModulo;
import org.springframework.stereotype.Component;


@Component
public class ManejadorCrearModulo implements ManejadorComandoRespuesta<ComandoSolicitudCrearModulo, ComandoRespuesta<Long>> {
    private final GenerarSolicitudCrearModulo generarSolicitudCrearModulo;
    private final ServicioCrearModulo servicioCrearModulo;

    public ManejadorCrearModulo(GenerarSolicitudCrearModulo generarSolicitudCrearModulo, ServicioCrearModulo servicioCrearModulo) {
        this.generarSolicitudCrearModulo = generarSolicitudCrearModulo;
        this.servicioCrearModulo = servicioCrearModulo;
    }


    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudCrearModulo comandoSolicitudCrearModulo) {
        return new ComandoRespuesta<>(servicioCrearModulo.ejecutar(generarSolicitudCrearModulo.crear(comandoSolicitudCrearModulo)));
    }
}
