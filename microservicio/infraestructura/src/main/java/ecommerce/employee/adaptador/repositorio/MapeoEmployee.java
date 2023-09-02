package ecommerce.employee.adaptador.repositorio;

import ecommerce.employees.modelo.entidad.Employee;
import ecommerce.infraestructura.jdbc.MapperResult;
import ecommerce.roles.modelo.entidad.Rol;
import ecommerce.roles.puerto.repositorio.RepositorioRol;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoEmployee implements RowMapper<Employee>, MapperResult {
    private final RepositorioRol repositorioRol;

    public MapeoEmployee(RepositorioRol repositorioRol) {
        this.repositorioRol = repositorioRol;
    }
    private Rol obtenerRol(Long id){
        return repositorioRol.obtener(id);
    }
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long idEmployee = rs.getLong("id");
        Long rol = rs.getLong("rol_id");
        String name = rs.getString("employee_name");
        String email = rs.getString("employee_email");
        String password = rs.getString("employee_password");
        String document = rs.getString("employee_document");
        String address = rs.getString("employee_address");
        String phoneNumber = rs.getString("employee_phone_number");
        String avatar = rs.getString("employee_avatar");
        boolean active = rs.getBoolean("employee_active");
        boolean notificationsEmail = rs.getBoolean("employee_notifications_email");
        return Employee.reconstruir(idEmployee, obtenerRol(rol), name, email, password, document, address, phoneNumber,avatar, active, notificationsEmail);
    }
}