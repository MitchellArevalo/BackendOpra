package ecommerce.salesproducts.puerto.dao;

import ecommerce.salesproducts.modelo.entidad.SaleProduct;

import java.util.List;

public interface DaoSaleProduct {
    SaleProduct obtenerPorId(Long id);
    List<SaleProduct> obtenerVentasDeProductosPorID(Long id);
    List<SaleProduct> obtenerVentasGenerales();

    List<SaleProduct> obtenerVentasPorIDVentaAprobadas(Long id);

    List<SaleProduct> obtenerProductosPorVenderPorIDVenta(Long idVenta);


}
