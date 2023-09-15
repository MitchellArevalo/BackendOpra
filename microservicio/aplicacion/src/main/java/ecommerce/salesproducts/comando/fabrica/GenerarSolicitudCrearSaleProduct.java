package ecommerce.salesproducts.comando.fabrica;

import ecommerce.productos.modelo.entidad.Product;
import ecommerce.productos.puerto.dao.DaoProduct;
import ecommerce.sales.modelo.entidad.Sale;
import ecommerce.sales.puerto.dao.DaoSale;
import ecommerce.salesproducts.comando.ComandoSolicitudCrearSaleProduct;
import ecommerce.salesproducts.modelo.entidad.SaleProduct;
import org.springframework.stereotype.Component;

@Component
public class GenerarSolicitudCrearSaleProduct {
    private final DaoProduct daoProduct;
    private final DaoSale daoSale;


    public GenerarSolicitudCrearSaleProduct(DaoProduct daoProduct, DaoSale daoSale) {
        this.daoProduct = daoProduct;
        this.daoSale = daoSale;
    }

    private Product obtenerProduct(Long id){
        return this.daoProduct.getByID(id);
    }
    private Sale obtenerSale(Long id){
        return this.daoSale.obtenerVentaPorID(id);
    }

    public SaleProduct generar(ComandoSolicitudCrearSaleProduct comandoSolicitudCrearSaleProduct){
        return SaleProduct.crear(obtenerSale(comandoSolicitudCrearSaleProduct.getIdSale()), obtenerProduct(comandoSolicitudCrearSaleProduct.getIdProduct()),
                comandoSolicitudCrearSaleProduct.getSaleProductQuantity(), comandoSolicitudCrearSaleProduct.getSaleProductSalesPrice());
    }
}
