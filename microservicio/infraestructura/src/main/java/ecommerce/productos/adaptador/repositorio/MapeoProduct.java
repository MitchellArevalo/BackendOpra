package ecommerce.productos.adaptador.repositorio;

import ecommerce.category.modelo.entidad.Category;
import ecommerce.category.puerto.dao.DaoCategory;
import ecommerce.productos.modelo.entidad.Product;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoProduct implements RowMapper<Product> {
    private final DaoCategory daoCategory;

    public MapeoProduct(DaoCategory daoCategory) {
        this.daoCategory = daoCategory;
    }

    private Category obtenerCategory(Long id){ return daoCategory.getCategoryByID(id); }

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String name = rs.getString("product_name");
        Long category = rs.getLong("category_id");
        String itemCode = rs.getString("product_item_code");
        String size = rs.getString("product_size");
        BigDecimal cost =rs.getBigDecimal("product_cost_price");
        BigDecimal salesPrice = rs.getBigDecimal("product_sales_price");
        String description = rs.getString("product_description");
        String image =rs.getString("product_image");
        Integer stock = rs.getInt("product_stock");
        return Product.reconstruir(id, name, obtenerCategory(category), itemCode, size, cost, salesPrice, description, image, stock);
    }
}
