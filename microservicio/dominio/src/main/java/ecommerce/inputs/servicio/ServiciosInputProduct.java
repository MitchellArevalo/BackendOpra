package ecommerce.inputs.servicio;

import ecommerce.inputs.modelo.entidad.InputProduct;
import ecommerce.inputs.puerto.repositorio.RepositorioInputProduct;
import ecommerce.productos.puerto.repositorio.RepositorioProduct;

import java.math.BigDecimal;

public class ServiciosInputProduct {
    private final RepositorioInputProduct repositorioInputProduct;
    private final RepositorioProduct repositorioProduct;
    public ServiciosInputProduct(RepositorioInputProduct repositorioInputProduct, RepositorioProduct repositorioProduct) {
        this.repositorioInputProduct = repositorioInputProduct;
        this.repositorioProduct = repositorioProduct;
    }

    public Long guardar(InputProduct inputProduct){
        try {
            BigDecimal addStock = BigDecimal.valueOf(inputProduct.getProduct().getStock()).add(inputProduct.getQuantityProduct());
            this.repositorioProduct.addToStock(inputProduct.getProduct().getId(), addStock);
            return this.repositorioInputProduct.crear(inputProduct);
        }
        catch (RuntimeException e){
            return 0001000L;
        }
    }

}
