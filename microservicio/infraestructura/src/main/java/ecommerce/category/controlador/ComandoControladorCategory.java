package ecommerce.category.controlador;

import ecommerce.ComandoRespuesta;
import ecommerce.category.comando.ComandoSolicitudCrearCategory;
import ecommerce.category.comando.manejador.ManejadorCrearCategory;
import ecommerce.employee.comando.ComandoSolicitudCrearEmployee;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@Tag(name = "Controlador comando category")
public class ComandoControladorCategory {
    private final ManejadorCrearCategory manejadorCrearCategory;

    public ComandoControladorCategory(ManejadorCrearCategory manejadorCrearCategory) {
        this.manejadorCrearCategory = manejadorCrearCategory;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Crear category", description = "Metodo para crear category nuevo")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSolicitudCrearCategory category){
        return this.manejadorCrearCategory.ejecutar(category);
    }
}
