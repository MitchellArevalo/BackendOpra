package ecommerce.sales.adaptador.dao;

import ecommerce.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import ecommerce.infraestructura.jdbc.EjecucionBaseDeDatos;
import ecommerce.infraestructura.jdbc.sqlstatement.SqlStatement;
import ecommerce.productos.adaptador.repositorio.MapeoProductDTO;
import ecommerce.productos.modelo.dto.ProductoDTO;
import ecommerce.sales.adaptador.repositorio.MapeoSale;
import ecommerce.sales.modelo.entidad.Sale;
import ecommerce.sales.puerto.dao.DaoSale;
import ecommerce.salesproducts.modelo.entidad.SaleProduct;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class DaoSalePostgres implements DaoSale {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoSale mapeoSale;
    private final MapeoProductDTO mapeoProductDTO;

    public DaoSalePostgres(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoSale mapeoSale, MapeoProductDTO mapeoProductDTO) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoSale = mapeoSale;
        this.mapeoProductDTO = mapeoProductDTO;
    }
    @SqlStatement(namespace = "sales", value = "obtenerSalePorId")
    private static String sqlObtenerSalePorID;
    @SqlStatement(namespace = "sales", value = "obtenerSaleListado")
    private static String sqlObtenerListado;
    @SqlStatement(namespace = "sales", value = "obtenerSalePorIdProductos")
    private static String sqlObtenerListadoPorVentaProducto;

    @SqlStatement(namespace = "sales", value = "obtenerVentasAprobadasPorMes")
    private static String sqlObtenerVentasAprobadasPorMes;

    @SqlStatement(namespace = "sales", value = "obtenerCantidadVentasWebsite")
    private static String sqlobtenerCantidadVentasWebsite;
    @SqlStatement(namespace = "sales", value = "obtenerCantidadVentasLocal")
    private static String sqlobtenerCantidadVentasLocal;
    @SqlStatement(namespace = "sales", value = "obtenerVentasRecientes")
    private static String sqlObtenerOrdenesVentaMasRecientes;
    @SqlStatement(namespace = "sales", value = "obtenerProductosMasVendidos")
    private static String sqlObtenerCantidadProductosMasVendidos;


    @Override
    public Sale obtenerVentaPorID(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().queryForObject(sqlObtenerSalePorID, parameterSource, mapeoSale));
    }

    @Override
    public List<Sale> obtenerTotalVentas() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerListado, mapeoSale);
    }

    @Override
    public List<SaleProduct> obtenerVentasPorIdProducto(Long id) {
        return null;
    }

    @Override
    public List<Sale> obtenerVentasPorFecha(LocalDateTime fechaInicial, LocalDateTime fechaFinal) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("sale_date_inicial", fechaInicial);
        parameterSource.addValue("sale_date_final", fechaFinal);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlObtenerVentasAprobadasPorMes, parameterSource, mapeoSale);
    }

    @Override
    public Long obtenerCantidadVentasWebsite() {
        Map<String, Object> params = Collections.emptyMap();
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlobtenerCantidadVentasWebsite, params, Long.class);
    }

    @Override
    public Long obtenerCantidadVentasLocal() {
        Map<String, Object> params = Collections.emptyMap();
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlobtenerCantidadVentasLocal, params, Long.class);
    }

    @Override
    public List<Sale> obtenerOrdenesDeVentaMasRecientes() {
        return customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerOrdenesVentaMasRecientes, mapeoSale);
    }

    @Override
    public List<ProductoDTO> obtenerCantidadProductosVendidos() {
        return customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerCantidadProductosMasVendidos, mapeoProductDTO);
    }
}
