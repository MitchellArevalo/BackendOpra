package ecommerce.payment.adaptador.dao;

import ecommerce.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import ecommerce.infraestructura.jdbc.EjecucionBaseDeDatos;
import ecommerce.infraestructura.jdbc.sqlstatement.SqlStatement;
import ecommerce.payment.adaptador.repositorio.MapeoPayment;
import ecommerce.payment.modelo.entidad.Payment;
import ecommerce.payment.puerto.dao.DaoPayment;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoPaymentPostgres implements DaoPayment {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private final MapeoPayment mapeoPayment;
    public DaoPaymentPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoPayment mapeoPayment) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoPayment = mapeoPayment;
    }
    @SqlStatement(namespace = "payment", value = "obtenerPaymentPorId")
    private static String sqlObtenerPorId;
    @SqlStatement(namespace = "payment", value = "obtenerListadoPayments")
    private static String sqlObtenerListado;
    @SqlStatement(namespace = "payment", value = "obtenerListadoPaymentsPorIdSale")
    private static String sqlObtenerListadoPorIdsale;

    @Override
    public Payment obtenerPaymentPorId(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorId, parameterSource, mapeoPayment));
    }

    @Override
    public List<Payment> obtenerListadoDePayments() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerListado, mapeoPayment);
    }

    @Override
    public List<Payment> obtenerListadoDePaymentsPorIdFactura(Long id) {
        return null;
    }
}
