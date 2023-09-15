package ecommerce.saleproducts.adaptador.repositorio;

import ecommerce.infraestructura.jdbc.MapperResult;
import ecommerce.productos.modelo.entidad.Product;
import ecommerce.productos.puerto.dao.DaoProduct;
import ecommerce.sales.modelo.entidad.Sale;
import ecommerce.sales.puerto.dao.DaoSale;
import ecommerce.salesproducts.modelo.entidad.SaleProduct;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Component
public class MapeoSaleProduct implements RowMapper<SaleProduct>, MapperResult {

    private final DaoProduct daoProduct;
    private final DaoSale daoSale;

    public MapeoSaleProduct(DaoProduct daoProduct, DaoSale daoSale) {
        this.daoProduct = daoProduct;
        this.daoSale = daoSale;
    }

    private Product obtenerProduct(Long id){
        return this.daoProduct.getByID(id);
    }
    private Sale obtenerSale(Long id){
        return this.daoSale.obtenerVentaPorID(id);
    }

    @Override
    public SaleProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long idSaleProduct = rs.getLong("id");
        Long idSale = rs.getLong("sale_id");
        Long idProduct = rs.getLong("product_id");
        Integer saleProductQuantity = rs.getInt("saleproduct_quantity");
        BigDecimal saleProductSalesPrice = rs.getBigDecimal("saleproduct_sale_price");
        BigDecimal saleProductProfit = rs.getBigDecimal("saleproduct_profit");
        String saleProductMarginProfit = rs.getString("saleproduct_margin_profit");
        BigDecimal saleProductTotal = rs.getBigDecimal("saleproduct_total");
        LocalDateTime saleProductDate = rs.getTimestamp("saleproduct_date").toLocalDateTime();
        return SaleProduct.reconstruir(idSaleProduct, obtenerSale(idSale), obtenerProduct(idProduct),
                saleProductQuantity, saleProductSalesPrice, saleProductProfit,
                saleProductMarginProfit, saleProductTotal, saleProductDate);
    }
}
