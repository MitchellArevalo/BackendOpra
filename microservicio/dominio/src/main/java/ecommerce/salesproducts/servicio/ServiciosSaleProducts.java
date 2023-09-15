package ecommerce.salesproducts.servicio;

import ecommerce.sales.modelo.entidad.Sale;
import ecommerce.sales.puerto.repositorio.RepositorioSale;
import ecommerce.salesproducts.modelo.entidad.SaleProduct;
import ecommerce.salesproducts.puerto.repositorio.RepositorioSaleProduct;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ServiciosSaleProducts {
    private final RepositorioSaleProduct repositorioSaleProduct;
    private final RepositorioSale repositorioSale;

    public ServiciosSaleProducts(RepositorioSaleProduct repositorioSaleProduct, RepositorioSale repositorioSale) {
        this.repositorioSaleProduct = repositorioSaleProduct;
        this.repositorioSale = repositorioSale;
    }

    public Long crear(SaleProduct saleProduct){
        definirValoresCamposDeVenta(saleProduct);
        return this.repositorioSaleProduct.crear(saleProduct);
    }

    private void definirValoresCamposDeVenta(SaleProduct saleProduct){
        Sale venta = saleProduct.getSale();
        BigDecimal valorTotalDeVenta = venta.getValorVenta().add(saleProduct.getSaleProductTotal());
        BigDecimal valorProfitTotalVenta = venta.getProfitVenta().add(saleProduct.getSaleProductProfit());
        if (venta.getValorVenta().equals(BigDecimal.ZERO) && venta.getProfitVenta().equals(BigDecimal.ZERO)){
            this.repositorioSale.modificarValoresVenta(saleProduct.getSale().getIdSale(), valorTotalDeVenta, valorProfitTotalVenta, saleProduct.getSaleProductMarginProfit());
        }
        else{
            String valorMargenProfitTotalVenta =  venta.getProfitVenta().divide(venta.getValorVenta(), 2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100))  + "%";
            this.repositorioSale.modificarValoresVenta(saleProduct.getSale().getIdSale(), valorTotalDeVenta, valorProfitTotalVenta, valorMargenProfitTotalVenta);
        }

    }

}
