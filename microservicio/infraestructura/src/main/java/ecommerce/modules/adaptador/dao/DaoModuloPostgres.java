package ecommerce.modules.adaptador.dao;

import ecommerce.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import ecommerce.infraestructura.jdbc.EjecucionBaseDeDatos;
import ecommerce.infraestructura.jdbc.sqlstatement.SqlStatement;
import ecommerce.modules.adaptador.repositorio.MapeoModulo;
import ecommerce.modules.modelo.entidad.Modulo;
import ecommerce.modules.puerto.dao.DaoModule;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoModuloPostgres implements DaoModule {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoModulo mapeoModulo;

    public DaoModuloPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoModulo mapeoModulo) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoModulo = mapeoModulo;
    }
    @SqlStatement(namespace = "module", value = "getByID")
    private static String sqlObtenerPorID;

    @SqlStatement(namespace = "module", value = "getAllModules")
    private static String sqlObtenerListado;


    @Override
    public List<Modulo> getAllModules() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerListado, mapeoModulo);
    }

    @Override
    public Modulo getByID(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorID, parameterSource, mapeoModulo));
    }
}
