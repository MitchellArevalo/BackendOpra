package ecommerce.outputsproducts.adaptador.dao;

import ecommerce.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import ecommerce.infraestructura.jdbc.EjecucionBaseDeDatos;
import ecommerce.infraestructura.jdbc.sqlstatement.SqlStatement;
import ecommerce.outputproducts.modelo.entidad.OutputProduct;
import ecommerce.outputproducts.puerto.dao.DaoOutputProduct;
import ecommerce.outputsproducts.adaptador.repositorio.MapeoOutputProduct;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoOutputProductPostgres implements DaoOutputProduct {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoOutputProduct mapeoOutputProduct;

    public DaoOutputProductPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoOutputProduct mapeoOutputProduct) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoOutputProduct = mapeoOutputProduct;
    }

    @SqlStatement(namespace = "outputproducts", value = "getOutputProductById")
    private static String sqlObtenerOutputProductByID;
    @SqlStatement(namespace = "outputproducts", value = "getListOutputProducts")
    private static String sqlObtenerListaOutputProducts;
    @SqlStatement(namespace = "outputproducts", value = "getOutputProductsListByIdProduct")
    private static String sqlObtenerListaOutputProductsByIDProduct;


    @Override
    public OutputProduct getByID(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().queryForObject(sqlObtenerOutputProductByID, parameterSource,mapeoOutputProduct));
    }

    @Override
    public List<OutputProduct> getAllOutputs() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerListaOutputProducts, mapeoOutputProduct);
    }

    @Override
    public List<OutputProduct> getAllOutputsByIdProduct(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("product_id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerListaOutputProductsByIDProduct, parameterSource, mapeoOutputProduct);
    }
}
