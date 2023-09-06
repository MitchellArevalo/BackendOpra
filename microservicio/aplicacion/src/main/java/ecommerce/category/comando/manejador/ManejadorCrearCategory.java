package ecommerce.category.comando.manejador;

import ecommerce.ComandoRespuesta;
import ecommerce.category.comando.ComandoSolicitudCrearCategory;
import ecommerce.category.comando.fabrica.GenerarSolicitudCrearCategory;
import ecommerce.category.servicio.ServiciosCategory;
import ecommerce.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearCategory implements ManejadorComandoRespuesta<ComandoSolicitudCrearCategory, ComandoRespuesta<Long>> {
    private final ServiciosCategory serviciosCategory;
    private final GenerarSolicitudCrearCategory generarSolicitudCrearCategory;

    public ManejadorCrearCategory(ServiciosCategory serviciosCategory, GenerarSolicitudCrearCategory generarSolicitudCrearCategory) {
        this.serviciosCategory = serviciosCategory;
        this.generarSolicitudCrearCategory = generarSolicitudCrearCategory;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudCrearCategory comando) {
        return new ComandoRespuesta<>(this.serviciosCategory.crear(generarSolicitudCrearCategory.generar(comando)));
    }
}
