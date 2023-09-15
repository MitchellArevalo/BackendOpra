package ecommerce.sales.consulta;

import ecommerce.productos.modelo.dto.ProductoDTO;
import ecommerce.sales.puerto.dao.DaoSale;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorObtenerProductosMasVendidos {
    private final DaoSale daoSale;

    public ManejadorObtenerProductosMasVendidos(DaoSale daoSale) {
        this.daoSale = daoSale;
    }

    public List<ProductoDTO> ejecutar(){
        return this.daoSale.obtenerCantidadProductosVendidos();
    }
}
