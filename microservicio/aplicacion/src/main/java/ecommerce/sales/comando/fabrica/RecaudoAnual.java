package ecommerce.sales.comando.fabrica;

import java.math.BigDecimal;

public class RecaudoAnual {
    private BigDecimal enero;
    private BigDecimal febrero;
    private BigDecimal marzo;
    private BigDecimal abril;
    private BigDecimal mayo;
    private BigDecimal junio;
    private BigDecimal julio;
    private BigDecimal agosto;
    private BigDecimal septiembre;
    private BigDecimal octubre;
    private BigDecimal noviembre;
    private BigDecimal diciembre;

    public RecaudoAnual(BigDecimal enero, BigDecimal febrero, BigDecimal marzo, BigDecimal abril, BigDecimal mayo, BigDecimal junio, BigDecimal julio, BigDecimal agosto, BigDecimal septiembre, BigDecimal octubre, BigDecimal noviembre, BigDecimal diciembre) {
        this.enero = enero;
        this.febrero = febrero;
        this.marzo = marzo;
        this.abril = abril;
        this.mayo = mayo;
        this.junio = junio;
        this.julio = julio;
        this.agosto = agosto;
        this.septiembre = septiembre;
        this.octubre = octubre;
        this.noviembre = noviembre;
        this.diciembre = diciembre;
    }

    public BigDecimal getEnero() {
        return enero;
    }

    public BigDecimal getFebrero() {
        return febrero;
    }

    public BigDecimal getMarzo() {
        return marzo;
    }

    public BigDecimal getAbril() {
        return abril;
    }

    public BigDecimal getMayo() {
        return mayo;
    }

    public BigDecimal getJunio() {
        return junio;
    }

    public BigDecimal getJulio() {
        return julio;
    }

    public BigDecimal getAgosto() {
        return agosto;
    }

    public BigDecimal getSeptiembre() {
        return septiembre;
    }

    public BigDecimal getOctubre() {
        return octubre;
    }

    public BigDecimal getNoviembre() {
        return noviembre;
    }

    public BigDecimal getDiciembre() {
        return diciembre;
    }
}
