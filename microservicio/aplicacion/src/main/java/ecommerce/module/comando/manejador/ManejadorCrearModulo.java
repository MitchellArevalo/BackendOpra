package ecommerce.module.comando.manejador;

import ecommerce.ComandoRespuesta;
import ecommerce.manejador.ManejadorComandoRespuesta;
import ecommerce.module.comando.ComandoSolicitudCrearModulo;
import ecommerce.module.comando.fabrica.GenerarSolicitudCrearModulo;
import ecommerce.modulos.servicios.ServiciosModule;
import org.springframework.stereotype.Component;


@Component
public class ManejadorCrearModulo implements ManejadorComandoRespuesta<ComandoSolicitudCrearModulo, ComandoRespuesta<Long>> {
    private final GenerarSolicitudCrearModulo generarSolicitudCrearModulo;
    private final ServiciosModule serviciosModule;

    public ManejadorCrearModulo(GenerarSolicitudCrearModulo generarSolicitudCrearModulo, ServiciosModule serviciosModule) {
        this.generarSolicitudCrearModulo = generarSolicitudCrearModulo;
        this.serviciosModule = serviciosModule;
    }


    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudCrearModulo comandoSolicitudCrearModulo) {
        return new ComandoRespuesta<>(serviciosModule.crear(generarSolicitudCrearModulo.crear(comandoSolicitudCrearModulo)));
    }
}
