package ecommerce.salesproducts.modelo.entidad;

import com.fasterxml.jackson.annotation.JsonFormat;
import ecommerce.dominio.ValidadorArgumento;
import ecommerce.productos.modelo.entidad.Product;
import ecommerce.sales.modelo.entidad.Sale;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

public class SaleProduct {
    private Long idSaleProduct;
    private Sale sale;
    private Product product;
    private Integer saleProductQuantity;
    private BigDecimal saleProductSalesPrice;
    private BigDecimal saleProductProfit;
    private String saleProductMarginProfit;
    private BigDecimal saleProductTotal;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime saleProductDate;

    public SaleProduct(Long idSaleProduct, Sale sale, Product product, Integer saleProductQuantity, BigDecimal saleProductSalesPrice, BigDecimal saleProductProfit, String saleProductMarginProfit, BigDecimal saleProductTotal, LocalDateTime saleProductDate) {
        this.idSaleProduct = idSaleProduct;
        this.sale = sale;
        this.product = product;
        this.saleProductQuantity = saleProductQuantity;
        this.saleProductSalesPrice = saleProductSalesPrice;
        this.saleProductProfit = saleProductProfit;
        this.saleProductMarginProfit = saleProductMarginProfit;
        this.saleProductTotal = saleProductTotal;
        this.saleProductDate = saleProductDate;
    }

    public static SaleProduct reconstruir(Long idSaleProduct, Sale sale, Product product, Integer saleProductQuantity, BigDecimal saleProductSalesPrice, BigDecimal saleProductProfit, String saleProductMarginProfit, BigDecimal saleProductTotal, LocalDateTime saleProductDate) {
        ValidadorArgumento.validarObligatorio(idSaleProduct, "Debes ingresar el ID de saleProduct para reconstruir el objeto");
        ValidadorArgumento.validarObligatorio(sale, "Debes ingresar el sale de saleProduct para reconstruir el objeto");
        ValidadorArgumento.validarObligatorio(product, "Debes ingresar el producto de saleProduct para reconstruir el objeto");
        ValidadorArgumento.validarObligatorio(saleProductQuantity, "Debes ingresar la cantidad de saleProduct para reconstruir el objeto");
        ValidadorArgumento.validarObligatorio(saleProductSalesPrice, "Debes ingresar el precio de venta de saleProduct para reconstruir el objeto");
        ValidadorArgumento.validarObligatorio(saleProductProfit, "Debes ingresar el profit de saleProduct para reconstruir el objeto");
        ValidadorArgumento.validarObligatorio(saleProductMarginProfit, "Debes ingresar el margin profit de saleProduct para reconstruir el objeto");
        ValidadorArgumento.validarObligatorio(saleProductTotal, "Debes ingresar el total de saleProduct para reconstruir el objeto");
        ValidadorArgumento.validarObligatorio(saleProductDate, "Debes ingresar la fecha de saleProduct para reconstruir el objeto");
        return new SaleProduct(idSaleProduct, sale, product, saleProductQuantity, saleProductSalesPrice, saleProductProfit, saleProductMarginProfit,saleProductTotal, saleProductDate);
    }

    public SaleProduct(Sale sale, Product product, Integer saleProductQuantity, BigDecimal saleProductSalesPrice) {
        this.sale = sale;
        this.product = product;
        this.saleProductQuantity = saleProductQuantity;
        this.saleProductSalesPrice = saleProductSalesPrice;
        definirCompraWebsiteOEnLocal();
        definirProfitYMarginProfit();
    }
    public static SaleProduct crear(Sale sale, Product product, Integer saleProductQuantity,  BigDecimal saleProductSalesPrice) {
        ValidadorArgumento.validarObligatorio(sale, "Debes ingresar el sale de saleProduct para reconstruir el objeto");
        ValidadorArgumento.validarObligatorio(product, "Debes ingresar el producto de saleProduct para reconstruir el objeto");
        ValidadorArgumento.validarObligatorio(saleProductQuantity, "Debes ingresar la cantidad de saleProduct para reconstruir el objeto");
        ValidadorArgumento.validarObligatorio(saleProductSalesPrice, "Debes ingresar el valor de la venta del producto en caso de ser venta en local para reconstruir el objeto");
        return new SaleProduct(sale, product, saleProductQuantity, saleProductSalesPrice);
    }

    public void definirCompraWebsiteOEnLocal(){
        if(this.saleProductSalesPrice.equals(BigDecimal.valueOf(-1))){
            BigDecimal valorTotalDeProductos = (BigDecimal.valueOf(this.saleProductQuantity)).multiply(this.product.getSalesPrice());
            this.saleProductTotal = valorTotalDeProductos;
        }else{
            this.saleProductTotal = definirTotal(this.saleProductQuantity, this.saleProductSalesPrice);
        }
    }

    private BigDecimal definirTotal(Integer cantidadProductos, BigDecimal valorDeVentaProductos){
        BigDecimal cantidadProductoEnBigDecimal = new BigDecimal(cantidadProductos);
        return cantidadProductoEnBigDecimal.multiply(valorDeVentaProductos);
    }

    private void definirProfitYMarginProfit( ){
        BigDecimal utilidadFinal =  this.saleProductTotal.subtract(this.product.getCost().multiply(BigDecimal.valueOf(this.saleProductQuantity)));
        this.saleProductProfit = utilidadFinal;
        this.saleProductMarginProfit = (utilidadFinal.divide(this.saleProductTotal, 2, RoundingMode.HALF_UP)).multiply(BigDecimal.valueOf(100)) + "%";
    }

    public Long getIdSaleProduct() {
        return idSaleProduct;
    }

    public Sale getSale() {
        return sale;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getSaleProductQuantity() {
        return saleProductQuantity;
    }

    public BigDecimal getSaleProductSalesPrice() {
        return saleProductSalesPrice;
    }

    public BigDecimal getSaleProductProfit() {
        return saleProductProfit;
    }

    public String getSaleProductMarginProfit() {
        return saleProductMarginProfit;
    }

    public BigDecimal getSaleProductTotal() {
        return saleProductTotal;
    }

    public LocalDateTime getSaleProductDate() {
        return saleProductDate;
    }
}
