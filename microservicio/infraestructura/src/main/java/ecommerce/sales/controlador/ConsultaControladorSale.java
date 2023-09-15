package ecommerce.sales.controlador;

import ecommerce.ComandoRespuesta;
import ecommerce.productos.comando.ComandoSolicitudCrearProduct;
import ecommerce.productos.modelo.entidad.Product;
import ecommerce.sales.consulta.ManejadorObtenerListadoVentas;
import ecommerce.sales.consulta.ManejadorObtenerSalePorID;
import ecommerce.sales.modelo.entidad.Sale;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
@Tag(name = "Controlador consulta sale")
public class ConsultaControladorSale {
    private final ManejadorObtenerSalePorID manejadorObtenerSalePorID;
    private final ManejadorObtenerListadoVentas manejadorObtenerListadoVentas;

    public ConsultaControladorSale(ManejadorObtenerSalePorID manejadorObtenerSalePorID, ManejadorObtenerListadoVentas manejadorObtenerListadoVentas) {
        this.manejadorObtenerSalePorID = manejadorObtenerSalePorID;
        this.manejadorObtenerListadoVentas = manejadorObtenerListadoVentas;
    }

    @GetMapping()
    @Operation(summary = "Visualizar todos", description = "Metodo utilizado para consultar los datos de products")
    public List<Sale> obtenerSales(){
        return manejadorObtenerListadoVentas.ejecutar();
    }
    @GetMapping("/{id}")
    public Sale obtenerSale(@PathVariable("id") Long id){
        return manejadorObtenerSalePorID.ejecutar(id);
    }



}
