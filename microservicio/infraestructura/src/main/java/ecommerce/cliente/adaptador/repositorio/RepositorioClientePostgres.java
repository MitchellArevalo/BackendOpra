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

    @Override
    public Long crear(Cliente cliente) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", cliente.getIdCliente());
        parameterSource.addValue("cliente_name", cliente.getNombre());
        parameterSource.addValue("cliente_email", cliente.getEmail());
        parameterSource.addValue("cliente_identity", cliente.getDocumento());
        parameterSource.addValue("cliente_address", cliente.getDireccion());
        parameterSource.addValue("cliente_phone_number", cliente.getNumeroTelefonico());
        parameterSource.addValue("cliente_username", cliente.getUsername());
        parameterSource.addValue("cliente_password", cliente.getContrasena());
        return this.customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrearCliente);
    }
}
