package ecommerce.sales.comando.fabrica;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

public class MesAnteriorConMesActual {
    private String mesAnterior;
    private BigDecimal valorMesAnterior;
    private String mesActual;
    private BigDecimal valorMesActual;

    public MesAnteriorConMesActual(BigDecimal valorMesAnterior, BigDecimal valorMesActual) {
        this.valorMesAnterior = valorMesAnterior;
        this.valorMesActual = valorMesActual;
    }

    public MesAnteriorConMesActual(String mesAnterior, BigDecimal valorMesAnterior, String mesActual, BigDecimal valorMesActual) {
        this.mesAnterior = mesAnterior;
        this.valorMesAnterior = valorMesAnterior;
        this.mesActual = mesActual;
        this.valorMesActual = valorMesActual;
    }

    public String getMesAnterior() {
        return mesAnterior;
    }

    public BigDecimal getValorMesAnterior() {
        return valorMesAnterior;
    }

    public String getMesActual() {
        return mesActual;
    }

    public BigDecimal getValorMesActual() {
        return valorMesActual;
    }
}
