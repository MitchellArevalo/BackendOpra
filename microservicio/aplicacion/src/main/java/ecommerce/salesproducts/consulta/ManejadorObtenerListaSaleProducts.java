package ecommerce.salesproducts.consulta;

import ecommerce.salesproducts.modelo.entidad.SaleProduct;
import ecommerce.salesproducts.puerto.dao.DaoSaleProduct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorObtenerListaSaleProducts {
    private final DaoSaleProduct daoSaleProduct;

    public ManejadorObtenerListaSaleProducts(DaoSaleProduct daoSaleProduct) {
        this.daoSaleProduct = daoSaleProduct;
    }
    public List<SaleProduct> ejecutar(){
        return this.daoSaleProduct.obtenerVentasGenerales();
    }
}
