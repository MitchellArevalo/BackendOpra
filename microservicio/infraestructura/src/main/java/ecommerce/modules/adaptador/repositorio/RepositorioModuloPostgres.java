package ecommerce.modules.adaptador.repositorio;

import ecommerce.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import ecommerce.infraestructura.jdbc.sqlstatement.SqlStatement;
import ecommerce.modules.modelo.entidad.Modulo;
import ecommerce.modules.puerto.repositorio.RepositorioModule;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioModuloPostgres implements RepositorioModule {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private final MapeoModulo mapeoModulo;

    public RepositorioModuloPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoModulo mapeoModulo) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoModulo = mapeoModulo;
    }

    @SqlStatement(namespace = "module", value = "createModule")
    private static String sqlCrearModulo;

    @SqlStatement(namespace = "module", value = "deleteModule")
    private static String sqlBorrarModulo;

    @SqlStatement(namespace = "module", value = "updateModule")
    private static String sqlActualizarModulo;

    @Override
    public Long crear(Modulo module) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("module_name",module.getName());
        parameterSource.addValue("module_edit",module.isEdit());
        parameterSource.addValue("module_create",module.isCreate());
        parameterSource.addValue("module_delete",module.isDelete());
        parameterSource.addValue("module_view",module.isView());
        return this.customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrearModulo);
    }

    @Override
    public void update(Modulo module, Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id",id);
        parameterSource.addValue("module_name",module.getName());
        parameterSource.addValue("module_edit",module.isEdit());
        parameterSource.addValue("module_create",module.isCreate());
        parameterSource.addValue("module_delete",module.isDelete());
        parameterSource.addValue("module_view",module.isView());
        this.customNamedParameterJdbcTemplate.crear(parameterSource, sqlActualizarModulo);
    }

    @Override
    public void delete(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlBorrarModulo, parameterSource);

    }
}
