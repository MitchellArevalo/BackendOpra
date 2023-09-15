package ecommerce.salesproducts.comando.manejador;

import ecommerce.ComandoRespuesta;
import ecommerce.manejador.ManejadorComandoRespuesta;
import ecommerce.salesproducts.comando.ComandoSolicitudCrearSaleProduct;
import ecommerce.salesproducts.comando.fabrica.GenerarSolicitudCrearSaleProduct;
import ecommerce.salesproducts.servicio.ServiciosSaleProducts;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearSaleProduct implements ManejadorComandoRespuesta<ComandoSolicitudCrearSaleProduct, ComandoRespuesta<Long>> {
    private final ServiciosSaleProducts serviciosSaleProducts;
    private final GenerarSolicitudCrearSaleProduct generarSolicitudCrearSaleProduct;

    public ManejadorCrearSaleProduct(ServiciosSaleProducts serviciosSaleProducts, GenerarSolicitudCrearSaleProduct generarSolicitudCrearSaleProduct) {
        this.serviciosSaleProducts = serviciosSaleProducts;
        this.generarSolicitudCrearSaleProduct = generarSolicitudCrearSaleProduct;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudCrearSaleProduct comando) {
        return new ComandoRespuesta<>(this.serviciosSaleProducts.crear(generarSolicitudCrearSaleProduct.generar(comando)));
    }
}
