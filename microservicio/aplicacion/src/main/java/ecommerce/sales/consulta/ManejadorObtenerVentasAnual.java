package ecommerce.sales.consulta;

import ecommerce.sales.modelo.entidad.Sale;
import ecommerce.sales.puerto.dao.DaoSale;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Component
public class ManejadorObtenerVentasAnual {
    private final DaoSale daoSale;

    public ManejadorObtenerVentasAnual(DaoSale daoSale) {
        this.daoSale = daoSale;
    }



    public List<Long> ejecutar(){
        List<Long> valoresDeVentaPorMes = new ArrayList<>();
            for (Month month : Month.values()) {
                YearMonth yearMonth = YearMonth.of(2023, month);
                LocalDateTime startOfMonth = yearMonth.atDay(1).atStartOfDay();
                LocalDateTime endOfMonth = yearMonth.atEndOfMonth().atTime(23, 59, 59);
                List<Sale> ventasPorMes = this.daoSale.obtenerVentasPorFecha(startOfMonth, endOfMonth);
                BigDecimal valorVenta = new BigDecimal(0);
                for (Sale venta: ventasPorMes) {
                    valorVenta = (valorVenta.add(venta.getValorVenta()));
                }

                valoresDeVentaPorMes.add(valorVenta.longValueExact());
            }
            return valoresDeVentaPorMes;
    }

}
