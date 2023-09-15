package ecommerce.payment.adaptador.repositorio;

import ecommerce.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import ecommerce.infraestructura.jdbc.sqlstatement.SqlStatement;
import ecommerce.payment.modelo.entidad.Payment;
import ecommerce.payment.puerto.repositorio.RepositorioPayment;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPaymentPostgres implements RepositorioPayment {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioPaymentPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }
    @SqlStatement(namespace = "payment", value = "crearPayment")
    private static String sqlCrearPayment;

    @Override
    public Long crear(Payment payment) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("sale_id", payment.getSale().getIdSale());
        parameterSource.addValue("payment_price", payment.getPriceToPay());
        return customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrearPayment);
    }
}
