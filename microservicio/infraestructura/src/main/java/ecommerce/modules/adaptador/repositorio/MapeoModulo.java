package ecommerce.modules.adaptador.repositorio;

import ecommerce.infraestructura.jdbc.MapperResult;
import ecommerce.modules.modelo.entidad.Modulo;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoModulo  implements RowMapper<Modulo>, MapperResult {
    @Override
    public Modulo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long idModulo = rs.getLong("id");
        String name = rs.getString("module_name");
        boolean edit = rs.getBoolean("module_edit");
        boolean view = rs.getBoolean("module_view");
        boolean create = rs.getBoolean("module_create");
        boolean delete = rs.getBoolean("module_delete");
        return Modulo.reconstruir(idModulo, name,edit,view,create,delete);
    }
}
