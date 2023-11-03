package ecommerce.sales.consulta;

import ecommerce.sales.comando.fabrica.CantidadVentasLocalyWebsite;
import ecommerce.sales.puerto.dao.DaoSale;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ManejadorObtenerCantidadVentasEnLocalYWebsite {
    private final DaoSale daoSale;

    public ManejadorObtenerCantidadVentasEnLocalYWebsite(DaoSale daoSale) {
        this.daoSale = daoSale;
    }

    public CantidadVentasLocalyWebsite ejecutar(){
        try{
            Long ventasLocal = this.daoSale.obtenerCantidadVentasLocal();
            Long ventasWebsite = daoSale.obtenerCantidadVentasWebsite();
            return new CantidadVentasLocalyWebsite(ventasLocal, ventasWebsite);
        }catch (RuntimeException e){
            throw new RuntimeException(e);
        }

    }
}
