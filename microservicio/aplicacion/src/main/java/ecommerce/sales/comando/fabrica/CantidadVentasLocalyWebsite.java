package ecommerce.sales.comando.fabrica;

import java.math.BigDecimal;

public class CantidadVentasLocalyWebsite {
    private final String LOCAL = "LOCAL";
    private BigDecimal cantidadVentasLocales;
    private final String WEBSITE = "WEBSITE";
    private BigDecimal cantidadVentasWebsite;

    public CantidadVentasLocalyWebsite(BigDecimal cantidadVentasLocales, BigDecimal cantidadVentasWebsite) {
        this.cantidadVentasLocales = cantidadVentasLocales;
        this.cantidadVentasWebsite = cantidadVentasWebsite;
    }
}
