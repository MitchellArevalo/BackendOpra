package ecommerce.saleproducts.adaptador.repositorio;

import ecommerce.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import ecommerce.infraestructura.jdbc.sqlstatement.SqlStatement;
import ecommerce.salesproducts.modelo.entidad.SaleProduct;
import ecommerce.salesproducts.puerto.repositorio.RepositorioSaleProduct;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioSaleProductPostgres implements RepositorioSaleProduct {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioSaleProductPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }
    @SqlStatement(namespace = "saleproducts", value = "crearSaleProduct")
    private static String sqlCrearSaleProduct;


    @Override
    public Long crear(SaleProduct saleProduct) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("sale_id", saleProduct.getSale().getIdSale());
        parameterSource.addValue("product_id", saleProduct.getProduct().getId());
        parameterSource.addValue("saleproduct_quantity", saleProduct.getSaleProductQuantity());
        parameterSource.addValue("saleproduct_sale_price", saleProduct.getSaleProductSalesPrice());
        parameterSource.addValue("saleproduct_profit", saleProduct.getSaleProductProfit());
        parameterSource.addValue("saleproduct_margin_profit", saleProduct.getSaleProductMarginProfit());
        parameterSource.addValue("saleproduct_total", saleProduct.getSaleProductTotal());
        return customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrearSaleProduct);
    }
}
