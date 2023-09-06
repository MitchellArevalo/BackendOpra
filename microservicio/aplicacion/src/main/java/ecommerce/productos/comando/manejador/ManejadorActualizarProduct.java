package ecommerce.productos.comando.manejador;

import ecommerce.productos.comando.ComandoSolicitudCrearProduct;
import ecommerce.productos.comando.fabrica.GenerarActualizarProduct;
import ecommerce.productos.servicio.ServiciosProduct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarProduct {
    private final ServiciosProduct serviciosProduct;
    private final GenerarActualizarProduct actualizarProduct;

    public ManejadorActualizarProduct(ServiciosProduct serviciosProduct, GenerarActualizarProduct actualizarProduct) {
        this.serviciosProduct = serviciosProduct;
        this.actualizarProduct = actualizarProduct;
    }
    public ResponseEntity<String> ejecutar(ComandoSolicitudCrearProduct product, Long id){
        try{
            serviciosProduct.update(actualizarProduct.generar(product),id);
            return new ResponseEntity<>("Producto actualizado con exito", HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>("Error al actualizar el product" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
