package ecommerce.payment.servicio;

import ecommerce.payment.modelo.entidad.Payment;
import ecommerce.payment.puerto.repositorio.RepositorioPayment;
import ecommerce.productos.modelo.entidad.Product;
import ecommerce.productos.puerto.repositorio.RepositorioProduct;
import ecommerce.sales.puerto.repositorio.RepositorioSale;
import ecommerce.salesproducts.modelo.entidad.SaleProduct;
import ecommerce.salesproducts.puerto.dao.DaoSaleProduct;

import java.math.BigDecimal;
import java.util.List;

public class ServiciosPayment {
    private final RepositorioPayment repositorioPayment;
    private final RepositorioSale repositorioSale;
    private final DaoSaleProduct daoSaleProduct;
    private final RepositorioProduct repositorioProduct;

    public ServiciosPayment(RepositorioPayment repositorioPayment, RepositorioSale repositorioSale, DaoSaleProduct daoSaleProduct, RepositorioProduct repositorioProduct) {
        this.repositorioPayment = repositorioPayment;
        this.repositorioSale = repositorioSale;
        this.daoSaleProduct = daoSaleProduct;
        this.repositorioProduct = repositorioProduct;
    }

    public Long crear(Payment payment){
        actualizarEstadoDeVenta(payment);
        return this.repositorioPayment.crear(payment);
    }

    public void removerProductoDeInventario(Long idVenta){
        List<SaleProduct> saleProducts = this.daoSaleProduct.obtenerProductosPorVenderPorIDVenta(idVenta);
        for (SaleProduct ventaDeProducto: saleProducts) {
            this.repositorioProduct.removeToStock(ventaDeProducto.getProduct().getId(), removerDelStock(ventaDeProducto));
        }

    }

    private void actualizarEstadoDeVenta(Payment payment){
        int comparacion = payment.getPriceToPay().compareTo(payment.getSale().getValorVenta());
        if(comparacion >= 0){
            removerProductoDeInventario(payment.getSale().getIdSale());
            this.repositorioSale.modificarEstadoVenta(payment.getSale().getIdSale(), "APROBADA");
        }
        else {
            this.repositorioSale.modificarEstadoVenta(payment.getSale().getIdSale(), "RECHAZADA");
        }
    }

    public BigDecimal removerDelStock(SaleProduct product){
      return BigDecimal.valueOf(product.getProduct().getStock()).subtract(BigDecimal.valueOf(product.getSaleProductQuantity()));
    }

}
