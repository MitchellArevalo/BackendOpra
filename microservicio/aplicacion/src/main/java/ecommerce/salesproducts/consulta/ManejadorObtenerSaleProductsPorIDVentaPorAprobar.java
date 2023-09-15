package ecommerce.salesproducts.consulta;

import ecommerce.salesproducts.modelo.entidad.SaleProduct;
import ecommerce.salesproducts.puerto.dao.DaoSaleProduct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorObtenerSaleProductsPorIDVentaPorAprobar {
    private final DaoSaleProduct daoSaleProduct;

    public ManejadorObtenerSaleProductsPorIDVentaPorAprobar(DaoSaleProduct daoSaleProduct) {
        this.daoSaleProduct = daoSaleProduct;
    }
    public List<SaleProduct> ejecutar(Long id){
        return this.daoSaleProduct.obtenerProductosPorVenderPorIDVenta(id);
    }
}
