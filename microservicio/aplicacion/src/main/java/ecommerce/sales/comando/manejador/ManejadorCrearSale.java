package ecommerce.sales.comando.manejador;

import ecommerce.ComandoRespuesta;
import ecommerce.manejador.ManejadorComandoRespuesta;
import ecommerce.sales.comando.ComandoSolicitudCrearSale;
import ecommerce.sales.comando.fabrica.GenerarSolicitudCrearSale;
import ecommerce.sales.servicio.ServiciosSales;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearSale implements ManejadorComandoRespuesta<ComandoSolicitudCrearSale, ComandoRespuesta<Long>> {
    private final ServiciosSales serviciosSales;
    private final GenerarSolicitudCrearSale solicitudCrearSale;

    public ManejadorCrearSale(ServiciosSales serviciosSales, GenerarSolicitudCrearSale solicitudCrearSale) {
        this.serviciosSales = serviciosSales;
        this.solicitudCrearSale = solicitudCrearSale;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudCrearSale comando) {
        return new ComandoRespuesta<>(serviciosSales.guardar(solicitudCrearSale.generar(comando)));
    }


}
