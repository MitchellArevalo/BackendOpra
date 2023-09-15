package ecommerce.sales.servicio;

import ecommerce.sales.modelo.entidad.Sale;
import ecommerce.sales.puerto.repositorio.RepositorioSale;

import java.math.BigDecimal;

public class ServiciosSales {
    private final RepositorioSale repositorioSale;

    public ServiciosSales(RepositorioSale repositorioSale) {
        this.repositorioSale = repositorioSale;
    }

    public Long guardar(Sale sale){
        return this.repositorioSale.guardar(sale);
    }

    public void modificarValoresVenta(Long idSale, BigDecimal amountSale, BigDecimal saleProfit, String marginProfitSale){
        this.repositorioSale.modificarValoresVenta(idSale, amountSale, saleProfit, marginProfitSale);
    }

    public void modificarEstadoVenta(Long id, String estado){
        this.repositorioSale.modificarEstadoVenta(id, estado);
    }
}
