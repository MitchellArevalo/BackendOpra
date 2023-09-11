package ecommerce.outputproducts.consulta;

import ecommerce.inputs.modelo.entidad.InputProduct;
import ecommerce.inputs.puerto.dao.DaoInputProduct;
import ecommerce.outputproducts.modelo.entidad.OutputProduct;
import ecommerce.outputproducts.puerto.dao.DaoOutputProduct;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerOutputProductById {
    private final DaoOutputProduct daoOutputProduct;

    public ManejadorObtenerOutputProductById(DaoOutputProduct daoOutputProduct) {
        this.daoOutputProduct = daoOutputProduct;
    }
    public OutputProduct ejecutar(Long id){
        return this.daoOutputProduct.getByID(id);
    }
}
