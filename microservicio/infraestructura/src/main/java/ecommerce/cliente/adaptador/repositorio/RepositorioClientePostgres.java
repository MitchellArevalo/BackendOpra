package ecommerce.cliente.adaptador.repositorio;

import ecommerce.cliente.modelo.entidad.Cliente;
import ecommerce.cliente.puerto.repositorio.RepositorioCliente;
import ecommerce.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import ecommerce.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioClientePostgres implements RepositorioCliente {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioClientePostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @SqlStatement(namespace = "cliente", value="crearcliente")
    private static String sqlCrearCliente;

    @SqlStatement(namespace = "cliente", value="updateCliente")
    private static String sqlUpdateCliente;
    @SqlStatement(namespace = "cliente", value="deleteCliente")
    private static String sqlDeleteCliente;
    @Override
    public Long crear(Cliente cliente) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", cliente.getIdCliente());
        parameterSource.addValue("client_name", cliente.getNombre());
        parameterSource.addValue("client_email", cliente.getEmail());
        parameterSource.addValue("client_identity", cliente.getDocumento());
        parameterSource.addValue("client_address", cliente.getDireccion());
        parameterSource.addValue("client_phone_number", cliente.getNumeroTelefonico());
        parameterSource.addValue("client_password", cliente.getContrasena());
        return this.customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrearCliente);
    }

    @Override
    public void delete(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlDeleteCliente, parameterSource);
    }

    @Override
    public void update(Cliente cliente, Long idCliente) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id",idCliente);
        parameterSource.addValue("client_name", cliente.getNombre());
        parameterSource.addValue("client_email", cliente.getEmail());
        parameterSource.addValue("client_identity", cliente.getDocumento());
        parameterSource.addValue("client_address", cliente.getDireccion());
        parameterSource.addValue("client_phone_number", cliente.getNumeroTelefonico());
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlUpdateCliente, parameterSource);
    }
}
