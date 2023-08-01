package ecommerce.personas.controlador;

import ecommerce.personas.consulta.ManejadorObtenerListadoPersonas;
import ecommerce.personas.consulta.ManejadorObtenerPersona;
import ecommerce.personas.modelo.entidad.Persona;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/persona")
@Tag(name = "Controlador consulta persona")
public class ConsultaControladorPersona {
    private final ManejadorObtenerPersona manejadorObtenerPersona;
    private final ManejadorObtenerListadoPersonas manejadorObtenerListadoPersonas;

    public ConsultaControladorPersona(ManejadorObtenerPersona manejadorObtenerPersona, ManejadorObtenerListadoPersonas manejadorObtenerListadoPersonas) {
        this.manejadorObtenerPersona = manejadorObtenerPersona;
        this.manejadorObtenerListadoPersonas = manejadorObtenerListadoPersonas;
    }
    @GetMapping()
    @Operation(summary = "Visualizar todos", description = "Metodo utilizado para consultar los datos de personas")
    public List<Persona> obtenerClientes(){
        return manejadorObtenerListadoPersonas.ejecutar();
    }
    @GetMapping("/{id}")
    public Persona obtenerCliente(@PathVariable("id") Long id){
        return manejadorObtenerPersona.ejecutar(id);
    }
}
