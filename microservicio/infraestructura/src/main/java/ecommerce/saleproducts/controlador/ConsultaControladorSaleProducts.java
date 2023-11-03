package ecommerce.saleproducts.controlador;


import ecommerce.productos.modelo.dto.ProductoDTO;
import ecommerce.sales.consulta.ManejadorObtenerProductosMasVendidos;
import ecommerce.salesproducts.consulta.ManejadorObtenerListaSaleProducts;
import ecommerce.salesproducts.consulta.ManejadorObtenerSaleProductPorID;
import ecommerce.salesproducts.consulta.ManejadorObtenerSaleProductsPorIDVenta;
import ecommerce.salesproducts.consulta.ManejadorObtenerSaleProductsPorIDVentaPorAprobar;
import ecommerce.salesproducts.modelo.entidad.SaleProduct;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/saleproducts")
@Tag(name = "Controlador consulta saleproducts")
public class ConsultaControladorSaleProducts {
    private final ManejadorObtenerSaleProductPorID manejadorObtenerSaleProductPorID;
    private final ManejadorObtenerListaSaleProducts manejadorObtenerListaSaleProducts;

    private final ManejadorObtenerSaleProductsPorIDVenta manejadorObtenerSaleProductsPorIDVenta;
    private final ManejadorObtenerSaleProductsPorIDVentaPorAprobar manejadorObtenerSaleProductsPorIDVentaPorAprobar;
    private final ManejadorObtenerProductosMasVendidos manejadorObtenerProductosMasVendidos;
    public ConsultaControladorSaleProducts(ManejadorObtenerSaleProductPorID manejadorObtenerSaleProductPorID, ManejadorObtenerListaSaleProducts manejadorObtenerListaSaleProducts, ManejadorObtenerSaleProductsPorIDVenta manejadorObtenerSaleProductsPorIDVenta, ManejadorObtenerSaleProductsPorIDVentaPorAprobar manejadorObtenerSaleProductsPorIDVentaPorAprobar, ManejadorObtenerProductosMasVendidos manejadorObtenerProductosMasVendidos) {
        this.manejadorObtenerSaleProductPorID = manejadorObtenerSaleProductPorID;
        this.manejadorObtenerListaSaleProducts = manejadorObtenerListaSaleProducts;
        this.manejadorObtenerSaleProductsPorIDVenta = manejadorObtenerSaleProductsPorIDVenta;
        this.manejadorObtenerSaleProductsPorIDVentaPorAprobar = manejadorObtenerSaleProductsPorIDVentaPorAprobar;
        this.manejadorObtenerProductosMasVendidos = manejadorObtenerProductosMasVendidos;
    }

    @GetMapping()
    @Operation(summary = "Visualizar todos", description = "Metodo utilizado para consultar los datos de los SaleProduct")
    public List<SaleProduct> obtenerSaleProductsList(){
        return manejadorObtenerListaSaleProducts.ejecutar();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Visualizar uno", description = "Metodo utilizado para consultar los datos de SaleProduct")
    public SaleProduct obtenerPorId(@PathVariable("id")Long id){
        return this.manejadorObtenerSaleProductPorID.ejecutar(id);
    }

    @GetMapping("/sale/{idVenta}")
    @Operation(summary = "Visualizar todos", description = "Metodo utilizado para consultar los datos de los SaleProduct")
    public List<SaleProduct> obtenerListaSaleProductsPorIDVenta(@PathVariable("idVenta")Long id){
        return manejadorObtenerSaleProductsPorIDVenta.ejecutar(id);
    }

    @GetMapping("/product/{idProduct}")
    @Operation(summary = "Visualizar todos", description = "Metodo utilizado para consultar los datos de los SaleProduct")
    public List<SaleProduct> obtenerListaSaleProductsPorIDProduct(@PathVariable("idProduct")Long id){
        return manejadorObtenerSaleProductsPorIDVenta.ejecutar(id);
    }

    @GetMapping("/sale/pending/{idProduct}")
    @Operation(summary = "Visualizar todos", description = "Metodo utilizado para consultar los datos de los SaleProduct")
    public List<SaleProduct> obtenerSaleProductsPorIDVentaPendiente(@PathVariable("idProduct")Long id){
        return manejadorObtenerSaleProductsPorIDVentaPorAprobar.ejecutar(id);
    }





}
