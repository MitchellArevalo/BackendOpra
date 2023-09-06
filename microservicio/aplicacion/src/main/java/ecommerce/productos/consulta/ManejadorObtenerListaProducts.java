package ecommerce.productos.consulta;

import ecommerce.productos.modelo.entidad.Product;
import ecommerce.productos.puerto.dao.DaoProduct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorObtenerListaProducts {
    private final DaoProduct daoProduct;

    public ManejadorObtenerListaProducts(DaoProduct daoProduct) {
        this.daoProduct = daoProduct;
    }
    public List<Product> ejecutar(){
        return daoProduct.getAllProducts();
    }
}
