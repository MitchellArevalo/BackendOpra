package ecommerce.productos.adaptador.repositorio;

import ecommerce.productos.modelo.dto.ProductoDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoProductDTO implements RowMapper<ProductoDTO> {
    @Override
    public ProductoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
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
        Long cantidadVentaProduct = rs.getLong("cantidad_producto_vendidos");
        return ProductoDTO.reconstruir(id, name, category, itemCode,size,cost,salesPrice,description,image,stock, cantidadVentaProduct);
    }
}
