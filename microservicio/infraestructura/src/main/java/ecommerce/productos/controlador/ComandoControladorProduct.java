package ecommerce.productos.controlador;

import ecommerce.ComandoRespuesta;
import ecommerce.employee.comando.ComandoActualizarEmployee;
import ecommerce.productos.comando.ComandoSolicitudCrearProduct;
import ecommerce.productos.comando.manejador.ManejadorActualizarProduct;
import ecommerce.productos.comando.manejador.ManejadorCrearProduct;
import ecommerce.productos.comando.manejador.ManejadorDeleteProduct;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@Tag(name = "Controlador comando product")
public class ComandoControladorProduct {
    private final ManejadorCrearProduct manejadorCrearProduct;
    private final ManejadorDeleteProduct manejadorDeleteProduct;
    private final ManejadorActualizarProduct manejadorActualizarProduct;
    public ComandoControladorProduct(ManejadorCrearProduct manejadorCrearProduct, ManejadorDeleteProduct manejadorDeleteProduct, ManejadorActualizarProduct manejadorActualizarProduct) {
        this.manejadorCrearProduct = manejadorCrearProduct;
        this.manejadorDeleteProduct = manejadorDeleteProduct;
        this.manejadorActualizarProduct = manejadorActualizarProduct;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Crear employee", description = "Metodo para crear prodct nuevo")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSolicitudCrearProduct comandoSolicitudCrearProduct){
        return this.manejadorCrearProduct.ejecutar(comandoSolicitudCrearProduct);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Employee", description = "Metodo para eliminar product")
    public ResponseEntity<String> borrar(@PathVariable("id") Long id){
        return manejadorDeleteProduct.ejecutar(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar Employee", description = "Metodo para actualizar product")
    public ResponseEntity<String> actualizar(@RequestBody ComandoSolicitudCrearProduct product, @PathVariable("id") Long id){
        return manejadorActualizarProduct.ejecutar(product, id);
    }
}
