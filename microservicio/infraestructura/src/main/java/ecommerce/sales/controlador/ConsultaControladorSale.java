package ecommerce.sales.controlador;

import ecommerce.sales.comando.fabrica.MesAnteriorConMesActual;
import ecommerce.sales.consulta.ManejadorObtenerGananciasTotalesConMesAnterior;
import ecommerce.sales.consulta.ManejadorObtenerListadoVentas;
import ecommerce.sales.consulta.ManejadorObtenerSalePorID;
import ecommerce.sales.modelo.entidad.Sale;
import ecommerce.sales.puerto.dao.DaoSale;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/sale")
@Tag(name = "Controlador consulta sale")
public class ConsultaControladorSale {
    private final ManejadorObtenerSalePorID manejadorObtenerSalePorID;
    private final ManejadorObtenerListadoVentas manejadorObtenerListadoVentas;
    private final DaoSale daoSale;
    private final ManejadorObtenerGananciasTotalesConMesAnterior manejadorObtenerGananciasTotalesConMesAnterior;

    public ConsultaControladorSale(ManejadorObtenerSalePorID manejadorObtenerSalePorID, ManejadorObtenerListadoVentas manejadorObtenerListadoVentas, DaoSale daoSale, ManejadorObtenerGananciasTotalesConMesAnterior manejadorObtenerGananciasTotalesConMesAnterior) {
        this.manejadorObtenerSalePorID = manejadorObtenerSalePorID;
        this.manejadorObtenerListadoVentas = manejadorObtenerListadoVentas;
        this.daoSale = daoSale;
        this.manejadorObtenerGananciasTotalesConMesAnterior = manejadorObtenerGananciasTotalesConMesAnterior;
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

    @GetMapping("/prueba")
    public List<Sale> obtenerSalePruebas(){
        LocalDateTime.now().minusMonths(1);
        return daoSale.obtenerVentasPorFecha(LocalDateTime.now().withDayOfMonth(1), LocalDateTime.now());
    }

    @GetMapping("/ganancias")
    public MesAnteriorConMesActual obtenerGanancias(){
        return this.manejadorObtenerGananciasTotalesConMesAnterior.ejecutar();
    }

}
