package ecommerce.modules.controlador;


import ecommerce.module.consulta.ManejadorListadoModules;
import ecommerce.module.consulta.ManejadorObtenerModule;
import ecommerce.modules.modelo.entidad.Modulo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/module")
@Tag(name = "Controlador consulta module")
public class ConsultaControladorModule {
    private final ManejadorObtenerModule manejadorObtenerModule;
    private final ManejadorListadoModules manejadorListadoModules;

    public ConsultaControladorModule(ManejadorObtenerModule manejadorObtenerModule, ManejadorListadoModules manejadorListadoModules) {
        this.manejadorObtenerModule = manejadorObtenerModule;
        this.manejadorListadoModules = manejadorListadoModules;
    }

    @GetMapping()
    @Operation(summary = "Visualizar todos", description = "Metodo utilizado para consultar los modulos")
    public List<Modulo> obtenerModulos(){
        return manejadorListadoModules.obtener();
    }
    @GetMapping("/{id}")
    public Modulo obtenerModulo(@PathVariable("id") Long id){
        return manejadorObtenerModule.obtener(id);
    }

}
