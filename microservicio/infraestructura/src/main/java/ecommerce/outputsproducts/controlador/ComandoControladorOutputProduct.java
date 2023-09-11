package ecommerce.outputsproducts.controlador;

import ecommerce.ComandoRespuesta;
import ecommerce.inputproducts.comando.ComandoSolicitudCrearInputProduct;
import ecommerce.inputproducts.comando.manejador.ManejadorCrearInputProduct;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/outputs")
@Tag(name = "Controlador comando outputs")
public class ComandoControladorOutputProduct {
    private final ManejadorCrearInputProduct manejadorCrearInputProduct;

    public ComandoControladorOutputProduct(ManejadorCrearInputProduct manejadorCrearInputProduct) {
        this.manejadorCrearInputProduct = manejadorCrearInputProduct;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Crear input of a product", description = "Metodo para crear input product nuevo")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSolicitudCrearInputProduct comandoSolicitudCrearInputProduct){
        return this.manejadorCrearInputProduct.ejecutar(comandoSolicitudCrearInputProduct);
    }

}
