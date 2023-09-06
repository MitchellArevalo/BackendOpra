package ecommerce.productos.comando.manejador;

import ecommerce.ComandoRespuesta;
import ecommerce.manejador.ManejadorComandoRespuesta;
import ecommerce.productos.comando.ComandoSolicitudCrearProduct;
import ecommerce.productos.comando.fabrica.GenerarComandoCrearProduct;
import ecommerce.productos.servicio.ServiciosProduct;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearProduct implements ManejadorComandoRespuesta<ComandoSolicitudCrearProduct, ComandoRespuesta<Long>> {
    private final ServiciosProduct serviciosProduct;
    private final GenerarComandoCrearProduct comandoCrearProduct;

    public ManejadorCrearProduct(ServiciosProduct serviciosProduct, GenerarComandoCrearProduct comandoCrearProduct) {
        this.serviciosProduct = serviciosProduct;
        this.comandoCrearProduct = comandoCrearProduct;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudCrearProduct comando) {
        return new ComandoRespuesta<>(serviciosProduct.crear(comandoCrearProduct.crear(comando)));
    }
}
