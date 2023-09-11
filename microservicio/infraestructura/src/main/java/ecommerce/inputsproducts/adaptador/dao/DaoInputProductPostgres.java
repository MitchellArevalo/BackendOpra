package ecommerce.inputsproducts.adaptador.dao;

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
public class DaoInputProductPostgres implements DaoInputProduct {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoInputProduct mapeoInputProduct;

    public DaoInputProductPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoInputProduct mapeoInputProduct) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoInputProduct = mapeoInputProduct;
    }

    @SqlStatement(namespace = "inputproducts", value = "getInputProductById")
    private static String sqlObtenerInputProductByID;
    @SqlStatement(namespace = "inputproducts", value = "getListInputProducts")
    private static String sqlObtenerListaInputProducts;
    @SqlStatement(namespace = "inputproducts", value = "getInputProductsListByIdProduct")
    private static String sqlObtenerListaInputProductsByIDProduct;


    @Override
    public InputProduct getByID(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().queryForObject(sqlObtenerInputProductByID, parameterSource, mapeoInputProduct));
    }

    @Override
    public List<InputProduct> getAllInputs() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerListaInputProducts, mapeoInputProduct);
    }

    @Override
    public List<InputProduct> getAllInputsByIdProduct(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("product_id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerListaInputProductsByIDProduct, parameterSource, mapeoInputProduct);
    }
}
