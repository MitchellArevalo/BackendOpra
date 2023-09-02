package ecommerce.employee.adaptador.repositorio;

import ecommerce.employees.modelo.entidad.Employee;
import ecommerce.employees.puerto.repositorio.RepositorioEmployee;
import ecommerce.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import ecommerce.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioEmployeePostgres implements RepositorioEmployee {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private final MapeoEmployee mapeoEmployee;

    public RepositorioEmployeePostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoEmployee mapeoEmployee) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoEmployee = mapeoEmployee;
    }

    @SqlStatement(namespace = "employee", value = "createEmployee")
    private static String sqlCrearEmployee;


    @Override
    public Long crear(Employee employee) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("rol_id", employee.getRol().getIdRol());
        parameterSource.addValue("employee_name", employee.getName());
        parameterSource.addValue("employee_email", employee.getEmail());
        parameterSource.addValue("employee_password", employee.getPassword());
        parameterSource.addValue("employee_document", employee.getDocument());
        parameterSource.addValue("employee_address", employee.getAddress());
        parameterSource.addValue("employee_phone_number", employee.getPhoneNumber());
        parameterSource.addValue("employee_avatar", employee.getAvatar());
        return this.customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrearEmployee);
    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void delete(Long id) {

    }
}