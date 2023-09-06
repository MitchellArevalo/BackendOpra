package ecommerce.employee.adaptador.repositorio;

import ecommerce.employees.modelo.dto.DataDTOEmployee;
import ecommerce.employees.modelo.entidad.Employee;
import ecommerce.employees.puerto.repositorio.RepositorioEmployee;
import ecommerce.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import ecommerce.infraestructura.jdbc.EjecucionBaseDeDatos;
import ecommerce.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioEmployeePostgres implements RepositorioEmployee {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoEmployee mapeoEmployee;
    private final MapeoDTOEmployee mapeoDTOEmployee;

    public RepositorioEmployeePostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoEmployee mapeoEmployee, MapeoDTOEmployee mapeoDTOEmployee) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoEmployee = mapeoEmployee;
        this.mapeoDTOEmployee = mapeoDTOEmployee;
    }

    @SqlStatement(namespace = "employee", value = "createEmployee")
    private static String sqlCrearEmployee;

    @SqlStatement(namespace = "employee", value = "deleteEmployee")
    private static String sqlBorrarEmployee;

    @SqlStatement(namespace = "employee", value = "updateEmployee")
    private static String sqlActualizarEmployee;

    @SqlStatement(namespace = "employee", value = "autenticarEmployee")
    private static String sqlAutenticar;


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
    public void update(Employee employee, Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        parameterSource.addValue("rol_id", employee.getRol().getIdRol());
        parameterSource.addValue("employee_name", employee.getName());
        parameterSource.addValue("employee_email", employee.getEmail());
        parameterSource.addValue("employee_document", employee.getDocument());
        parameterSource.addValue("employee_address", employee.getAddress());
        parameterSource.addValue("employee_phone_number", employee.getPhoneNumber());
        parameterSource.addValue("employee_avatar", employee.getAvatar());
        parameterSource.addValue("employee_active", employee.isActive());
        parameterSource.addValue("employee_notifications_email", employee.isNotificationsEmail());
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlActualizarEmployee, parameterSource);
    }

    @Override
    public Employee autenticar(String email) {
    MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("employee_email", email);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().queryForObject(sqlAutenticar, parameterSource, mapeoEmployee));
    }

    @Override
    public void delete(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlBorrarEmployee, parameterSource);
    }
}
