package ecommerce.modulesrol.controlador;

import ecommerce.modules.modelo.entidad.Modulo;
import ecommerce.modulesrol.consulta.ManejadorObtenerListadoModulosPorRol;
import ecommerce.modulesrol.consulta.ManejadorObtenerModuloRol;
import ecommerce.modulesrol.consulta.ManejadorObtenerModulosRol;
import ecommerce.modulesrol.modelo.entidad.ModulesRol;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/modulosrol")
@Tag(name = "Controlador consulta modulos rol")
public class ConsultaControladoModulosRol {
    private final ManejadorObtenerModuloRol manejadorObtenerModuloRol;
    private final ManejadorObtenerModulosRol lManejadorObtenerModulosRol;

    private final ManejadorObtenerListadoModulosPorRol listadoModulosPorRol;
    public ConsultaControladoModulosRol(ManejadorObtenerModuloRol manejadorObtenerModuloRol, ManejadorObtenerModulosRol lManejadorObtenerModulosRol, ManejadorObtenerListadoModulosPorRol listadoModulosPorRol) {
        this.manejadorObtenerModuloRol = manejadorObtenerModuloRol;
        this.lManejadorObtenerModulosRol = lManejadorObtenerModulosRol;
        this.listadoModulosPorRol = listadoModulosPorRol;
    }
    @GetMapping()
    @Operation(summary = "Visualizar todos", description = "Metodo utilizado para consultar los datos de personas")
    public List<ModulesRol> obtenerModulos(){
        return lManejadorObtenerModulosRol.ejecutar();
    }
    @GetMapping("/{id}")
    public ModulesRol obtenerModulo(@PathVariable("id") Long id){
        return manejadorObtenerModuloRol.ejecutar(id);
    }

    @GetMapping("/rol/{rol_id}")
    public List<Modulo> obtenerModulosByRol(@PathVariable("rol_id") Long id){
        return listadoModulosPorRol.ejecutar(id);
    }

}
