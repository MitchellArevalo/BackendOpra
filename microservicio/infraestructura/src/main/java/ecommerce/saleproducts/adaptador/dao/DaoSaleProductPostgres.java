package ecommerce.saleproducts.adaptador.dao;

import ecommerce.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import ecommerce.infraestructura.jdbc.EjecucionBaseDeDatos;
import ecommerce.infraestructura.jdbc.sqlstatement.SqlStatement;
import ecommerce.saleproducts.adaptador.repositorio.MapeoSaleProduct;
import ecommerce.salesproducts.modelo.entidad.SaleProduct;
import ecommerce.salesproducts.puerto.dao.DaoSaleProduct;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoSaleProductPostgres implements DaoSaleProduct {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoSaleProduct mapeoSaleProduct;
    public DaoSaleProductPostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoSaleProduct mapeoSaleProduct) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoSaleProduct = mapeoSaleProduct;
    }
    @SqlStatement(namespace = "saleproducts", value = "obtenerSalePorId")
    private static String sqlObtenerSaleProductPorID;
    @SqlStatement(namespace = "saleproducts", value = "obtenerListaSaleProducts")
    private static String sqlObtenerListaSaleProducts;
    @SqlStatement(namespace = "saleproducts", value = "obtenerListaSaleProductsPorIdProducto")
    private static String sqlObtenerListaSaleProductsPorIdProducto;

    @SqlStatement(namespace = "saleproducts", value = "obtenerSaleProductsPorIDVentaAprobadas")
    private static String sqlObtenerPorIDVenta;

    @SqlStatement(namespace = "saleproducts", value = "obtenerSaleProductsPorIDVenta")
    private static String sqlObtenerListaSaleProductsPorIDVenta;
    @Override
    public SaleProduct obtenerPorId(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().queryForObject(sqlObtenerSaleProductPorID, parameterSource, mapeoSaleProduct));
    }

    @Override
    public List<SaleProduct> obtenerVentasDeProductosPorID(Long id) {
        return null;
    }

    @Override
    public List<SaleProduct> obtenerVentasGenerales() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerListaSaleProducts, mapeoSaleProduct);
    }

    @Override
    public List<SaleProduct> obtenerVentasPorIDVentaAprobadas(Long idVenta) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("sale_id", idVenta);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlObtenerPorIDVenta, parameterSource, mapeoSaleProduct);
    }

    @Override
    public List<SaleProduct> obtenerProductosPorVenderPorIDVenta(Long idVenta) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("sale_id", idVenta);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlObtenerListaSaleProductsPorIDVenta, parameterSource, mapeoSaleProduct);
    }

}
