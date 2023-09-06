package ecommerce.productos.adaptador.dao;

import ecommerce.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import ecommerce.infraestructura.jdbc.EjecucionBaseDeDatos;
import ecommerce.infraestructura.jdbc.sqlstatement.SqlStatement;
import ecommerce.productos.adaptador.repositorio.MapeoProduct;
import ecommerce.productos.modelo.entidad.Product;
import ecommerce.productos.puerto.dao.DaoProduct;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoProductPostgres implements DaoProduct {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoProduct mapeoProduct;

    public DaoProductPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoProduct mapeoProduct) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoProduct = mapeoProduct;
    }


    @SqlStatement(namespace = "producto", value = "obtenerporid")
    private static String sqlObtenerPorID;

    @SqlStatement(namespace = "producto", value = "getAllProducts")
    private static String sqlObtenerListado;

    @Override
    public Product getByID(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorID, parameterSource, mapeoProduct));
    }

    @Override
    public List<Product> getAllProducts() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerListado, mapeoProduct);
    }
}
