package ecommerce.cliente.adaptador.repositorio;

import ecommerce.cliente.modelo.entidad.Cliente;
import ecommerce.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoCliente implements RowMapper<Cliente>, MapperResult {
    @Override
    public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long idCliente = rs.getLong("id");
        String nombre = rs.getString("client_name");
        String email = rs.getString("client_email");
        String documento = rs.getString("client_identity");
        String direccion = rs.getString("client_address");
        String numeroTelefonico = rs.getString("client_phone_number");
        String contrasena = rs.getString("client_password");
        return Cliente.reconstruir(idCliente,nombre,documento,numeroTelefonico,direccion,email,contrasena);
    }
}
