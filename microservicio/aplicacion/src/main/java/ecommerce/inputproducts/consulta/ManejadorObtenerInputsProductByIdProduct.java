package ecommerce.inputproducts.consulta;

import ecommerce.inputs.modelo.entidad.InputProduct;
import ecommerce.inputs.puerto.dao.DaoInputProduct;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ManejadorObtenerInputsProductByIdProduct {
    private final DaoInputProduct daoInputProduct;

    public ManejadorObtenerInputsProductByIdProduct(DaoInputProduct daoInputProduct) {
        this.daoInputProduct = daoInputProduct;
    }

    public List<InputProduct> ejecutar(Long id){
        return this.daoInputProduct.getAllInputsByIdProduct(id);
    }

}
