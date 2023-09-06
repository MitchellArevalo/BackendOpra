package ecommerce.category.adaptador.dao;

import ecommerce.category.adaptador.repositorio.MapeoCategory;
import ecommerce.category.modelo.entidad.Category;
import ecommerce.category.puerto.dao.DaoCategory;
import ecommerce.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import ecommerce.infraestructura.jdbc.EjecucionBaseDeDatos;
import ecommerce.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoCategoryPostgres implements DaoCategory {
    private final MapeoCategory mapeoCategory;
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public DaoCategoryPostgres(MapeoCategory mapeoCategory, CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.mapeoCategory = mapeoCategory;
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @SqlStatement(namespace = "category", value = "getAllCategories")
    private static String sqlObtenerAllCategories;
    @SqlStatement(namespace = "category", value = "getByIDCategory")
    private static String sqlObtenerCategory;

    @Override
    public List<Category> getAllCategories() {
        return customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerAllCategories, mapeoCategory);
    }

    @Override
    public Category getCategoryByID(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlObtenerCategory,parameterSource, mapeoCategory));
    }
}
