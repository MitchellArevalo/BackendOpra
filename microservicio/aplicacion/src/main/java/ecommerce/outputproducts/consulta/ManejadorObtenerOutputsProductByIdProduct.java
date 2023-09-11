package ecommerce.outputproducts.consulta;

import ecommerce.inputs.modelo.entidad.InputProduct;
import ecommerce.inputs.puerto.dao.DaoInputProduct;
import ecommerce.outputproducts.modelo.entidad.OutputProduct;
import ecommerce.outputproducts.puerto.dao.DaoOutputProduct;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ManejadorObtenerOutputsProductByIdProduct {
    private final DaoOutputProduct daoOutputProduct;

    public ManejadorObtenerOutputsProductByIdProduct(DaoOutputProduct daoOutputProduct) {
        this.daoOutputProduct = daoOutputProduct;
    }

    public List<OutputProduct> ejecutar(Long id){
        return this.daoOutputProduct.getAllOutputsByIdProduct(id);
    }

}
