package ecommerce.inputproducts.consulta;

import ecommerce.inputs.modelo.entidad.InputProduct;
import ecommerce.inputs.puerto.dao.DaoInputProduct;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerInputProductById {
    private final DaoInputProduct daoInputProduct;

    public ManejadorObtenerInputProductById(DaoInputProduct daoInputProduct) {
        this.daoInputProduct = daoInputProduct;
    }
    public InputProduct ejecutar(Long id){
        return this.daoInputProduct.getByID(id);
    }
}
