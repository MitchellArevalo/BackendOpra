package ecommerce.payment.adaptador.repositorio;

import ecommerce.payment.modelo.entidad.Payment;
import ecommerce.sales.modelo.entidad.Sale;
import ecommerce.sales.puerto.dao.DaoSale;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Component
public class MapeoPayment implements RowMapper<Payment> {
    private final DaoSale daoSale;

    public MapeoPayment(DaoSale daoSale) {
        this.daoSale = daoSale;
    }
    private Sale obtenerSale(Long id){
        return daoSale.obtenerVentaPorID(id);
    }
    @Override
    public Payment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        Long idSale = rs.getLong("sale_id");
        BigDecimal priceToPay = rs.getBigDecimal("payment_price");
        LocalDateTime paymentDate = rs.getTimestamp("payment_date").toLocalDateTime();
        return Payment.reconstruir(id, obtenerSale(idSale), priceToPay, paymentDate);
    }
}
