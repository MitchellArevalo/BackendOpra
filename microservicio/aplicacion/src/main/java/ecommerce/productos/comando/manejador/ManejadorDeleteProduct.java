package ecommerce.productos.comando.manejador;

import ecommerce.productos.servicio.ServiciosProduct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ManejadorDeleteProduct {
    private final ServiciosProduct serviciosProduct;

    public ManejadorDeleteProduct(ServiciosProduct serviciosProduct) {
        this.serviciosProduct = serviciosProduct;
    }
    public ResponseEntity<String> ejecutar(Long id){
        try{
            serviciosProduct.delete(id);
            return new ResponseEntity<>("Producto eliminado con exito", HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>("Error al eliminar el product", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
