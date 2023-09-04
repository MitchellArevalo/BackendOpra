package ecommerce.employee.adaptador.repositorio;

import ecommerce.employees.modelo.dto.DataDTOEmployee;
import ecommerce.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoDTOEmployee implements RowMapper<DataDTOEmployee>, MapperResult {
    @Override
    public DataDTOEmployee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long idEmployee = rs.getLong("id");
        String name = rs.getString("employee_name");
        String email = rs.getString("employee_email");
        String document = rs.getString("employee_document");
        String address = rs.getString("employee_address");
        return DataDTOEmployee.reconstruir(idEmployee, name, email, document, address);
    }
}
