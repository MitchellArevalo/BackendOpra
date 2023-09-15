package ecommerce.sales.adaptador.repositorio;

import ecommerce.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import ecommerce.infraestructura.jdbc.sqlstatement.SqlStatement;
import ecommerce.sales.modelo.entidad.Sale;
import ecommerce.sales.puerto.repositorio.RepositorioSale;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class RepositorioSalePostgres implements RepositorioSale {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioSalePostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @SqlStatement(namespace = "sales", value = "crearSale")
    private static String sqlCrearSale;

    @SqlStatement(namespace = "sales", value = "actualizarEstadoVenta")
    private static String sqlActualizarEstado;
    @SqlStatement(namespace = "sales", value = "actualizarValoresVenta")
    private static String sqlActualizarValores;

    @Override
    public Long guardar(Sale sale) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("employee_id", sale.getEmployee().getIdEmployee());
        parameterSource.addValue("client_id", sale.getCliente().getIdCliente());
        parameterSource.addValue("sale_type", sale.getTipoVenta());
        return this.customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrearSale);
    }

    @Override
    public void modificarValoresVenta(Long idSale, BigDecimal amountSale, BigDecimal saleProfit, String marginProfitSale) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id",idSale);
        parameterSource.addValue("sale_amount", amountSale);
        parameterSource.addValue("sale_profit", saleProfit);
        parameterSource.addValue("sale_margin_profit", marginProfitSale);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlActualizarValores, parameterSource);
    }

    @Override
    public void modificarEstadoVenta(Long idSale, String estado) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", idSale);
        parameterSource.addValue("sale_status", estado);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlActualizarEstado, parameterSource);
    }
}
