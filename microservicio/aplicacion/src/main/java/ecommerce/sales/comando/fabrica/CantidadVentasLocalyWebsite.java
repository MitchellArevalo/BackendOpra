package ecommerce.sales.comando.fabrica;

import java.math.BigDecimal;

public class CantidadVentasLocalyWebsite {
    private String LOCAL;
    private Long cantidadVentasLocales;
    private String WEBSITE;
    private Long cantidadVentasWebsite;


    public CantidadVentasLocalyWebsite(Long cantidadVentasLocales, Long cantidadVentasWebsite) {
        this.cantidadVentasLocales = cantidadVentasLocales;
        this.LOCAL = "LOCAL";
        this.cantidadVentasWebsite = cantidadVentasWebsite;
        this.WEBSITE = "WEBSITE";
    }



    public String getLOCAL() {
        return LOCAL;
    }

    public Long getCantidadVentasLocales() {
        return cantidadVentasLocales;
    }

    public String getWEBSITE() {
        return WEBSITE;
    }

    public Long getCantidadVentasWebsite() {
        return cantidadVentasWebsite;
    }
}
