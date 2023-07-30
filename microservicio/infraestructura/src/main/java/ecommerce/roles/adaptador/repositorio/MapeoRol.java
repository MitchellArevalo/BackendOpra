package ecommerce.roles.adaptador.repositorio;

import ecommerce.infraestructura.jdbc.MapperResult;
import ecommerce.roles.modelo.entidad.Rol;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoRol implements RowMapper<Rol>, MapperResult {

    @Override
    public Rol mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long idRol = resultSet.getLong("id");
        String nombre = resultSet.getString("rol_name");
        return Rol.reconstruir(idRol, nombre);
    }
}
