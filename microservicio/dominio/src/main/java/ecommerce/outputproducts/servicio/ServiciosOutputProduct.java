package ecommerce.outputproducts.servicio;

import ecommerce.outputproducts.modelo.entidad.OutputProduct;
import ecommerce.outputproducts.puerto.repositorio.RepositorioOutputProduct;
import ecommerce.productos.puerto.repositorio.RepositorioProduct;

import java.math.BigDecimal;

public class ServiciosOutputProduct {
    private final RepositorioOutputProduct repositorioOutputProduct;
    private final RepositorioProduct repositorioProduct;
    public ServiciosOutputProduct(RepositorioOutputProduct repositorioOutputProduct, RepositorioProduct repositorioProduct) {
        this.repositorioOutputProduct = repositorioOutputProduct;
        this.repositorioProduct = repositorioProduct;
    }

    public Long guardar(OutputProduct outputProduct){
        try {
            BigDecimal removeStock = BigDecimal.valueOf(outputProduct.getProduct().getStock()).subtract(outputProduct.getQuantityProduct());
            this.repositorioProduct.removeToStock(outputProduct.getProduct().getId(), removeStock);
            return this.repositorioOutputProduct.crear(outputProduct);
        }
        catch (RuntimeException e){
            return 0001000L;
        }
    }

}
