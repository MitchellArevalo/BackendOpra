package ecommerce.sales.consulta;

import ecommerce.sales.modelo.entidad.Sale;
import ecommerce.sales.puerto.dao.DaoSale;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorObtenerListadoVentas {
    private final DaoSale daoSale;

    public ManejadorObtenerListadoVentas(DaoSale daoSale) {
        this.daoSale = daoSale;
    }

    public List<Sale> ejecutar(){
        return this.daoSale.obtenerTotalVentas();
    }
}
