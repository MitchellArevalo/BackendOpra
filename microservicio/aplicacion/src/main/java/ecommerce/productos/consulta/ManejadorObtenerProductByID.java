package ecommerce.productos.consulta;

import ecommerce.productos.modelo.entidad.Product;
import ecommerce.productos.puerto.dao.DaoProduct;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerProductByID {
    private final DaoProduct daoProduct;

    public ManejadorObtenerProductByID(DaoProduct daoProduct) {
        this.daoProduct = daoProduct;
    }

    public Product ejecutar(Long id){
        return daoProduct.getByID(id);
    }
}
