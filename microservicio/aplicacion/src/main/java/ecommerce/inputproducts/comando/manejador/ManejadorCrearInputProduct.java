package ecommerce.inputproducts.comando.manejador;

import ecommerce.ComandoRespuesta;
import ecommerce.inputproducts.comando.ComandoSolicitudCrearInputProduct;
import ecommerce.inputproducts.comando.fabrica.GenerarSolicitudCrearInputProduct;
import ecommerce.inputs.servicio.ServiciosInputProduct;
import ecommerce.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearInputProduct implements ManejadorComandoRespuesta<ComandoSolicitudCrearInputProduct,ComandoRespuesta<Long>> {
    private final ServiciosInputProduct serviciosInputProduct;
    private final GenerarSolicitudCrearInputProduct generarSolicitudCrearInputProduct;

    public ManejadorCrearInputProduct(ServiciosInputProduct serviciosInputProduct, GenerarSolicitudCrearInputProduct generarSolicitudCrearInputProduct) {
        this.serviciosInputProduct = serviciosInputProduct;
        this.generarSolicitudCrearInputProduct = generarSolicitudCrearInputProduct;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudCrearInputProduct comando) {
        return new ComandoRespuesta<>(serviciosInputProduct.guardar(generarSolicitudCrearInputProduct.generar(comando)));
    }
}
