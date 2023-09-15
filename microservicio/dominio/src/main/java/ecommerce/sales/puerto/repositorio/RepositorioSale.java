package ecommerce.sales.puerto.repositorio;

import ecommerce.sales.modelo.entidad.Sale;

import java.math.BigDecimal;

public interface RepositorioSale {
    Long guardar(Sale sale);
    void modificarValoresVenta(Long idSale, BigDecimal amountSale, BigDecimal saleProfit, String marginProfitSale);
    void modificarEstadoVenta(Long idSale, String estado);

}
