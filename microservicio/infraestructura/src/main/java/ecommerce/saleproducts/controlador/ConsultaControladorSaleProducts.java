package ecommerce.saleproducts.controlador;


import ecommerce.roles.modelo.entidad.Rol;
import ecommerce.sales.consulta.ManejadorObtenerSalePorID;
import ecommerce.salesproducts.consulta.ManejadorObtenerListaSaleProducts;
import ecommerce.salesproducts.consulta.ManejadorObtenerSaleProductPorID;
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

    public ConsultaControladorSaleProducts(ManejadorObtenerSaleProductPorID manejadorObtenerSaleProductPorID, ManejadorObtenerListaSaleProducts manejadorObtenerListaSaleProducts) {
        this.manejadorObtenerSaleProductPorID = manejadorObtenerSaleProductPorID;
        this.manejadorObtenerListaSaleProducts = manejadorObtenerListaSaleProducts;
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



}
