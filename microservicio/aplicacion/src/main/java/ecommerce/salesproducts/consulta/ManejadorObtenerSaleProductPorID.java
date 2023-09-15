package ecommerce.salesproducts.consulta;

import ecommerce.salesproducts.modelo.entidad.SaleProduct;
import ecommerce.salesproducts.puerto.dao.DaoSaleProduct;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerSaleProductPorID {
    private final DaoSaleProduct daoSaleProduct;

    public ManejadorObtenerSaleProductPorID(DaoSaleProduct daoSaleProduct) {
        this.daoSaleProduct = daoSaleProduct;
    }
    public SaleProduct ejecutar(Long id){
        return this.daoSaleProduct.obtenerPorId(id);
    }
}
