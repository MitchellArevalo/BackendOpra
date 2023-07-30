package ecommerce.roles.controlador;

import ecommerce.roles.consulta.ManejadorObtenerRol;
import ecommerce.roles.modelo.entidad.Rol;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rol")
@Tag(name = "Controlador consulta rol")
public class ConsultaControladorRol {
    private final ManejadorObtenerRol manejadorObtenerRol;

    private final ManejadorObtenerListaRol manejadorObtenerListaRol;

    public ConsultaControladorRol(ManejadorObtenerRol manejadorObtenerRol, ManejadorObtenerListaRol manejadorObtenerListaRol) {
        this.manejadorObtenerRol = manejadorObtenerRol;
        this.manejadorObtenerListaRol = manejadorObtenerListaRol;
    }

    @GetMapping()
    @Operation(summary = "Visualizar todos", description = "Metodo utilizado para consultar los datos de los roles")
    public List<Rol> obtenerRol(){
        return manejadorObtenerListaRol.ejecutar();
    }
    @GetMapping("/{id}")
    public Rol obtenerCliente(@PathVariable("id") Long id){
        return manejadorObtenerRol.ejecutar(id);
    }

}
