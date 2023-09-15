package ecommerce.sales.consulta;

import ecommerce.sales.modelo.entidad.Sale;
import ecommerce.sales.puerto.dao.DaoSale;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerSalePorID {
    private final DaoSale daoSale;

    public ManejadorObtenerSalePorID(DaoSale daoSale) {
        this.daoSale = daoSale;
    }

    public Sale ejecutar(Long id){
        return this.daoSale.obtenerVentaPorID(id);
    }
}
