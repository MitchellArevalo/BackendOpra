package ecommerce.productos.adaptador.repositorio;

import ecommerce.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import ecommerce.infraestructura.jdbc.sqlstatement.SqlStatement;
import ecommerce.productos.modelo.entidad.Product;
import ecommerce.productos.puerto.repositorio.RepositorioProduct;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class RepositorioProductPostgres implements RepositorioProduct {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioProductPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @SqlStatement(namespace = "producto", value = "createProduct")
    private static String sqlCrearProduct;

    @SqlStatement(namespace = "producto", value = "deleteProduct")
    private static String sqlDeleteProduct;


    @SqlStatement(namespace = "producto", value = "updateProduct")
    private static String sqlUpdateProduct;

    @SqlStatement(namespace = "producto", value = "addToStock")
    private static String sqlAddStock;

    @SqlStatement(namespace = "producto", value = "removeToStock")
    private static String sqlRemoveStock;

    @SqlStatement(namespace = "producto", value = "updateSalesPriceProduct")
    private static String sqlUpdateSalesPriceProduct;
    @SqlStatement(namespace = "producto", value = "updateCostPriceProduct")
    private static String sqlUpdateCostPriceProduct;

    @Override
    public Long crear(Product product) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("product_name", product.getName());
        parameterSource.addValue("product_item_code", product.getItemCode());
        parameterSource.addValue("product_size", product.getSize());
        parameterSource.addValue("product_sales_price", product.getSalesPrice().intValueExact());
        parameterSource.addValue("product_cost_price", product.getCost().intValueExact());
        parameterSource.addValue("product_stock", product.getStock());
        parameterSource.addValue("product_description", product.getDescription());
        parameterSource.addValue("product_image", product.getImage());
        parameterSource.addValue("category_id", product.getCategory().getId());
        return customNamedParameterJdbcTemplate.crear(parameterSource,sqlCrearProduct);
    }

    @Override
    public void update(Product product, Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id",id);
        parameterSource.addValue("product_name", product.getName());
        parameterSource.addValue("product_item_code", product.getItemCode());
        parameterSource.addValue("product_size", product.getSize());
        parameterSource.addValue("product_description", product.getDescription());
        parameterSource.addValue("product_image", product.getImage());
        parameterSource.addValue("category_id", product.getCategory().getId());
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlUpdateProduct, parameterSource);

    }

    @Override
    public void delete(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlDeleteProduct, parameterSource);

    }

    @Override
    public void addToStock(Long id, BigDecimal quantityStock) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        parameterSource.addValue("product_stock", quantityStock);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlAddStock, parameterSource);
    }

    @Override
    public void removeToStock(Long id, BigDecimal quantityStock) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        parameterSource.addValue("product_stock", quantityStock);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlRemoveStock, parameterSource);
    }

    @Override
    public void updateSalesPriceProduct(Long id, BigDecimal salesPriceProduct) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        parameterSource.addValue("product_sales_price", salesPriceProduct);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlUpdateSalesPriceProduct, parameterSource);
    }

    @Override
    public void updateCostPriceProduct(Long id, BigDecimal costPriceProduct) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        parameterSource.addValue("product_cost_price", costPriceProduct);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlUpdateCostPriceProduct, parameterSource);
    }
}
