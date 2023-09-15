package ecommerce.sales.consulta;

import ecommerce.sales.comando.fabrica.MesAnteriorConMesActual;
import ecommerce.sales.modelo.entidad.Sale;
import ecommerce.sales.puerto.dao.DaoSale;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

@Component
public class ManejadorObtenerVentasTotalesConMesAnterior {
    private final DaoSale daoSale;

    public ManejadorObtenerVentasTotalesConMesAnterior(DaoSale daoSale) {
        this.daoSale = daoSale;
    }
    public MesAnteriorConMesActual ejecutar(){
        LocalDateTime inicioMesActual = LocalDateTime.now().withDayOfMonth(1);
        LocalDateTime mesActual = LocalDateTime.now().withDayOfMonth(30);
        Month mesPresente = LocalDateTime.now().getMonth();
        String nombreMesActual = mesPresente.getDisplayName(TextStyle.FULL, Locale.getDefault());

        LocalDateTime inicioMesPasado = inicioMesActual.minusMonths(1);
        LocalDateTime finalMesPasado = mesActual.minusMonths(1);
        Month mesAnterior = inicioMesPasado.getMonth();
        String nombreMesAnterior = mesAnterior.getDisplayName(TextStyle.FULL, Locale.getDefault());

        List<Sale> ventasMesActual = daoSale.obtenerVentasPorFecha(inicioMesActual, mesActual);
        List<Sale> ventasMesPasado = daoSale.obtenerVentasPorFecha(inicioMesPasado, finalMesPasado);

        BigDecimal gananciasMesActual = new BigDecimal(0);
        for (Sale ventas: ventasMesActual) {
            gananciasMesActual = gananciasMesActual.add(ventas.getValorVenta());
        }
        BigDecimal gananciasMesPasado = new BigDecimal(0);
        for (Sale ventas: ventasMesPasado) {
            gananciasMesPasado = gananciasMesPasado.add(ventas.getValorVenta());
        }
        return new MesAnteriorConMesActual(nombreMesAnterior, gananciasMesPasado, nombreMesActual, gananciasMesActual);
    }
}
