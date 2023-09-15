package ecommerce.cliente.adaptador.dao;

import ecommerce.cliente.adaptador.repositorio.MapeoCliente;
import ecommerce.cliente.modelo.entidad.Cliente;
import ecommerce.cliente.puerto.dao.DaoCliente;
import ecommerce.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import ecommerce.infraestructura.jdbc.EjecucionBaseDeDatos;
import ecommerce.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class DaoClientePostgres implements DaoCliente {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoCliente mapeoCliente;

    public DaoClientePostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoCliente mapeoCliente) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoCliente = mapeoCliente;
    }


    @SqlStatement(namespace = "cliente", value = "getByID")
    private static String sqlObtenerPorID;

    @SqlStatement(namespace = "cliente", value = "getAllClients")
    private static String sqlObtenerListado;
    @SqlStatement(namespace = "cliente", value = "getQuantityClients")
    private static String sqlObtenerCantidadClientes;
    @Override
    public List<Cliente> getAllClients() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerListado, mapeoCliente);
    }

    @Override
    public Cliente getClienteById(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorID, parameterSource, mapeoCliente));
    }

    @Override
    public Long getTotalClients() {
        Map<String, Object> params = Collections.emptyMap();
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlObtenerCantidadClientes, params, Long.class);
    }
}
