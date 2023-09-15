package ecommerce.outputsproducts.controlador;

import ecommerce.ComandoRespuesta;
import ecommerce.infraestructura.error.ManejadorError;
import ecommerce.inputproducts.comando.manejador.ManejadorCrearInputProduct;
import ecommerce.outputproducts.comando.ComandoSolicitudCrearOutputProduct;
import ecommerce.outputproducts.comando.manejador.ManejadorCrearOutputProduct;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/outputs")
@Tag(name = "Controlador comando outputs")
public class ComandoControladorOutputProduct  {
    private final ManejadorCrearOutputProduct manejadorCrearOutputProduct;

    public ComandoControladorOutputProduct(ManejadorCrearOutputProduct manejadorCrearOutputProduct) {
        this.manejadorCrearOutputProduct = manejadorCrearOutputProduct;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Crear input of a product", description = "Metodo para crear input product nuevo")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSolicitudCrearOutputProduct comandoSolicitudCrearOutputProduct){
        return this.manejadorCrearOutputProduct.ejecutar(comandoSolicitudCrearOutputProduct);
    }

}
