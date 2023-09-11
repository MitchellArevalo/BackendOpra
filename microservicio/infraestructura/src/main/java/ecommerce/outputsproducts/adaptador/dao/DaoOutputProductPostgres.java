package ecommerce.outputsproducts.adaptador.dao;

import ecommerce.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import ecommerce.infraestructura.jdbc.EjecucionBaseDeDatos;
import ecommerce.infraestructura.jdbc.sqlstatement.SqlStatement;
import ecommerce.inputs.modelo.entidad.InputProduct;
import ecommerce.inputs.puerto.dao.DaoInputProduct;
import ecommerce.inputsproducts.adaptador.repositorio.MapeoInputProduct;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoOutputProductPostgres implements DaoInputProduct {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoInputProduct mapeoInputProduct;

    public DaoOutputProductPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoInputProduct mapeoInputProduct) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoInputProduct = mapeoInputProduct;
    }

    @SqlStatement(namespace = "outputproducts", value = "getOutputProductById")
    private static String sqlObtenerOutputProductByID;
    @SqlStatement(namespace = "outputproducts", value = "getListOutputProducts")
    private static String sqlObtenerListaOutputProducts;
    @SqlStatement(namespace = "outputproducts", value = "getOutputProductsListByIdProduct")
    private static String sqlObtenerListaOutputProductsByIDProduct;


    @Override
    public InputProduct getByID(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().queryForObject(sqlObtenerOutputProductByID, parameterSource, mapeoInputProduct));
    }

    @Override
    public List<InputProduct> getAllInputs() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerListaOutputProducts, mapeoInputProduct);
    }

    @Override
    public List<InputProduct> getAllInputsByIdProduct(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("product_id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerListaOutputProductsByIDProduct, parameterSource, mapeoInputProduct);
    }
}
