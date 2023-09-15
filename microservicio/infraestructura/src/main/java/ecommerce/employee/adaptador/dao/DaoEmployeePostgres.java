package ecommerce.employee.adaptador.dao;

import ecommerce.employee.adaptador.repositorio.MapeoDTOEmployee;
import ecommerce.employee.adaptador.repositorio.MapeoEmployee;
import ecommerce.employees.modelo.entidad.Employee;
import ecommerce.employees.puerto.dao.DaoEmployee;
import ecommerce.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import ecommerce.infraestructura.jdbc.EjecucionBaseDeDatos;
import ecommerce.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoEmployeePostgres implements DaoEmployee {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoDTOEmployee mapeoDTOEmployee;

    private final MapeoEmployee mapeoEmployee;
    @SqlStatement(namespace = "employee", value = "getByID")
    private static String sqlObtenerPorID;

    @SqlStatement(namespace = "employee", value = "getAllEmployees")
    private static String sqlObtenerListado;

    @SqlStatement(namespace = "employee", value = "getByIDWithoutPassword")
    private static String sqlObtenerPorIDWithoutPassword;
    @SqlStatement(namespace = "employee", value = "getDataDTOEmployee")
    private static String sqlObtenerDTO;

    public DaoEmployeePostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoDTOEmployee mapeoDTOEmployee, MapeoEmployee mapeoEmployee) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoDTOEmployee = mapeoDTOEmployee;
        this.mapeoEmployee = mapeoEmployee;
    }

    @Override
    public Employee getEmployee(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorID, parameterSource, mapeoEmployee));
    }

    @Override
    public ecommerce.employees.modelo.dto.DataDTOEmployee getDTOEmployee(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().queryForObject(sqlObtenerDTO, parameterSource, mapeoDTOEmployee));
    }

    @Override
    public List<Employee> getListEmployees() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerListado, mapeoEmployee);
    }
}
