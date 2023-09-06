package ecommerce.productos.comando.fabrica;

import ecommerce.category.modelo.entidad.Category;
import ecommerce.category.puerto.dao.DaoCategory;
import ecommerce.productos.comando.ComandoSolicitudCrearProduct;
import ecommerce.productos.modelo.entidad.Product;
import org.springframework.stereotype.Component;

@Component
public class GenerarActualizarProduct {
    private final DaoCategory daoCategory;

    public GenerarActualizarProduct(DaoCategory daoCategory) {
        this.daoCategory = daoCategory;
    }

    private Category obtenerCategory(Long id){
        return daoCategory.getCategoryByID(id);
    }
    public Product generar(ComandoSolicitudCrearProduct comando){
        return Product.crear(comando.getName(), obtenerCategory(comando.getIdCategory()), comando.getItemCode(), comando.getSize(),
                comando.getDescription(), comando.getImage());
    }
}
