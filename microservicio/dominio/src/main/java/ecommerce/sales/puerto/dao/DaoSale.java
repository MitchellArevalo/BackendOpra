package ecommerce.sales.puerto.dao;

import ecommerce.sales.modelo.entidad.Sale;
import ecommerce.salesproducts.modelo.entidad.SaleProduct;

import java.util.List;

public interface DaoSale {
    Sale obtenerVentaPorID(Long id);
    List<Sale> obtenerTotalVentas();

    List<SaleProduct> obtenerVentasPorIdProducto(Long id);



}
