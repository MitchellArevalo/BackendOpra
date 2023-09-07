package ecommerce.modulesrol.adaptador.repositorio;

import ecommerce.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import ecommerce.infraestructura.jdbc.sqlstatement.SqlStatement;
import ecommerce.modulesrol.modelo.entidad.ModulesRol;
import ecommerce.modulesrol.puerto.repositorio.RepositorioModulesRol;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioModulosRolPostgres implements RepositorioModulesRol {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioModulosRolPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @SqlStatement(namespace = "modulesrol", value = "createModulesRol")
    private static String sqlCrearModuloRol;

    @SqlStatement(namespace = "modulesrol", value = "deleteModulesRol")
    private static String sqlDeleteModuloRol;

    @SqlStatement(namespace = "modulesrol", value = "updateModulesRol")
    private static String sqlUpdateModuloRol;

    @Override
    public Long crear(ModulesRol modulesRol) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("module_id", modulesRol.getModulo().getIdModulo());
        parameterSource.addValue("rol_id", modulesRol.getRol().getIdRol());
        return customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrearModuloRol);
    }

    @Override
    public void update(ModulesRol modulesRol, Long id) {

    }

    @Override
    public void delete(Long id) {

    }
}
