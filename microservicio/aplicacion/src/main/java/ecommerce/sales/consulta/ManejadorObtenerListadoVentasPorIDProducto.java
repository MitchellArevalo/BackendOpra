package ecommerce.sales.consulta;

import ecommerce.sales.puerto.dao.DaoSale;
import ecommerce.salesproducts.modelo.entidad.SaleProduct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorObtenerListadoVentasPorIDProducto {
    private final DaoSale daoSale;

    public ManejadorObtenerListadoVentasPorIDProducto(DaoSale daoSale) {
        this.daoSale = daoSale;
    }

    public List<SaleProduct> ejecutar(Long id){
        return this.daoSale.obtenerVentasPorIdProducto(id);
    }

}
