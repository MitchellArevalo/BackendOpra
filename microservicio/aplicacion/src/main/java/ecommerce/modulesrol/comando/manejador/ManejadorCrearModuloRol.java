package ecommerce.modulesrol.comando.manejador;

import ecommerce.ComandoRespuesta;
import ecommerce.manejador.ManejadorComandoRespuesta;
import ecommerce.modulesrol.comando.ComandoSolicitudCrearModuloRol;
import ecommerce.modulesrol.comando.fabrica.GenerarSolicitudCrearModuloRol;
import ecommerce.modulesrol.servicio.ServiciosModulesRol;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearModuloRol implements ManejadorComandoRespuesta<ComandoSolicitudCrearModuloRol, ComandoRespuesta<Long>> {

    private final GenerarSolicitudCrearModuloRol generarSolicitudCrearModuloRol;

    private final ServiciosModulesRol serviciosModulesRol;

    public ManejadorCrearModuloRol(GenerarSolicitudCrearModuloRol generarSolicitudCrearModuloRol, ServiciosModulesRol serviciosModulesRol) {
        this.generarSolicitudCrearModuloRol = generarSolicitudCrearModuloRol;
        this.serviciosModulesRol = serviciosModulesRol;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudCrearModuloRol comando) {
        return new ComandoRespuesta<>(serviciosModulesRol.crear(generarSolicitudCrearModuloRol.crear(comando)));
    }
}
