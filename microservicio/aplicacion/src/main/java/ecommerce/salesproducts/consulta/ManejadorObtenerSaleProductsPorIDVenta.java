package ecommerce.salesproducts.consulta;

import ecommerce.salesproducts.modelo.entidad.SaleProduct;
import ecommerce.salesproducts.puerto.dao.DaoSaleProduct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorObtenerSaleProductsPorIDVenta {
    private final DaoSaleProduct daoSaleProduct;

    public ManejadorObtenerSaleProductsPorIDVenta(DaoSaleProduct daoSaleProduct) {
        this.daoSaleProduct = daoSaleProduct;
    }

    public List<SaleProduct> ejecutar(Long id){
        return this.daoSaleProduct.obtenerVentasPorIDVentaAprobadas(id);
    }
}
