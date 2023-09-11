package ecommerce.modulesrol.adaptador.dao;

import ecommerce.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import ecommerce.infraestructura.jdbc.EjecucionBaseDeDatos;
import ecommerce.infraestructura.jdbc.sqlstatement.SqlStatement;
import ecommerce.modules.adaptador.repositorio.MapeoModulo;
import ecommerce.modules.modelo.entidad.Modulo;
import ecommerce.modulesrol.adaptador.repositorio.MapeoModulosRol;
import ecommerce.modulesrol.modelo.entidad.ModulesRol;
import ecommerce.modulesrol.puerto.dao.DaoModulesRol;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoModulosRolPostgres implements DaoModulesRol {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoModulosRol mapeoModulosRol;
    private final MapeoModulo mapeoModulo;

    public DaoModulosRolPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoModulosRol mapeoModulosRol, MapeoModulo mapeoModulo) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoModulosRol = mapeoModulosRol;
        this.mapeoModulo = mapeoModulo;
    }

    @SqlStatement(namespace = "modulesrol", value = "getByID")
    private static String sqlObtenerPorID;

    @SqlStatement(namespace = "modulesrol", value = "getAllModules")
    private static String sqlObtenerListado;
    @SqlStatement(namespace = "modulesrol", value = "sqlObtenerModulosPorRol")
    private static String sqlObtenerModulosPorRol;

    @Override
    public ModulesRol getModuleRol(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorID, parameterSource, mapeoModulosRol));
    }

    @Override
    public List<ModulesRol> getAllModulesByRol() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerListado, mapeoModulosRol);
    }

    @Override
    public List<Modulo> getModulesByIDRol(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("rol_id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().query(sqlObtenerModulosPorRol, parameterSource, mapeoModulo));
    }


}
