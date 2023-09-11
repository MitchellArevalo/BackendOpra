package ecommerce.inputproducts.consulta;

import ecommerce.inputs.modelo.entidad.InputProduct;
import ecommerce.inputs.puerto.dao.DaoInputProduct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorObtenerListaDeInputProducts {
    private final DaoInputProduct daoInputProduct;

    public ManejadorObtenerListaDeInputProducts(DaoInputProduct daoInputProduct) {
        this.daoInputProduct = daoInputProduct;
    }

    public List<InputProduct> ejecutar(){
        return this.daoInputProduct.getAllInputs();
    }

}
