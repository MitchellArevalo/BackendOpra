package ecommerce.outputproducts.comando.manejador;

import ecommerce.ComandoRespuesta;
import ecommerce.inputproducts.comando.fabrica.GenerarSolicitudCrearInputProduct;
import ecommerce.manejador.ManejadorComandoRespuesta;
import ecommerce.outputproducts.comando.ComandoSolicitudCrearOutputProduct;
import ecommerce.outputproducts.comando.fabrica.GenerarSolicitudCrearOutputProduct;
import ecommerce.outputproducts.servicio.ServiciosOutputProduct;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearOutputProduct implements ManejadorComandoRespuesta<ComandoSolicitudCrearOutputProduct,ComandoRespuesta<Long>> {
    private final ServiciosOutputProduct serviciosOutputProduct;
    private final GenerarSolicitudCrearOutputProduct generarSolicitudCrearOutputProduct;

    public ManejadorCrearOutputProduct(ServiciosOutputProduct serviciosOutputProduct, GenerarSolicitudCrearOutputProduct generarSolicitudCrearOutputProduct) {
        this.serviciosOutputProduct = serviciosOutputProduct;
        this.generarSolicitudCrearOutputProduct = generarSolicitudCrearOutputProduct;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudCrearOutputProduct comando) {
        return new ComandoRespuesta<>(serviciosOutputProduct.guardar(generarSolicitudCrearOutputProduct.generar(comando)));
    }
}
