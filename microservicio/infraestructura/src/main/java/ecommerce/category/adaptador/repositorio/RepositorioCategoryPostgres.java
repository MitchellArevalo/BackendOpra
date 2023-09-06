package ecommerce.category.adaptador.repositorio;

import ecommerce.category.modelo.entidad.Category;
import ecommerce.category.puerto.repositorio.RepositorioCategory;
import ecommerce.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import ecommerce.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCategoryPostgres implements RepositorioCategory {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioCategoryPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @SqlStatement(namespace = "category", value = "crearCategory")
    private static String sqlCrearCategory;
    @SqlStatement(namespace = "category", value = "deleteCategory")
    private static String sqlEliminarCategory;
    @SqlStatement(namespace = "category", value = "updateCategory")
    private static String sqlUpdateCategory;



    @Override
    public Long crear(Category category) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("category_name", category.getNameCategory());
        return customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrearCategory);
    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public void update(Category category, Long id) {

    }
}
