package ecommerce.outputproducts.consulta;

import ecommerce.inputs.puerto.dao.DaoInputProduct;
import ecommerce.outputproducts.modelo.entidad.OutputProduct;
import ecommerce.outputproducts.puerto.dao.DaoOutputProduct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorObtenerListaDeOutputProducts {
    private final DaoOutputProduct daoOutputProduct;

    public ManejadorObtenerListaDeOutputProducts(DaoOutputProduct daoOutputProduct) {
        this.daoOutputProduct = daoOutputProduct;
    }

    public List<OutputProduct> ejecutar(){
        return this.daoOutputProduct.getAllOutputs();
    }

}
