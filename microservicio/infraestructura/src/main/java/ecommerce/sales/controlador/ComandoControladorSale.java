package ecommerce.sales.controlador;

import ecommerce.ComandoRespuesta;
import ecommerce.productos.comando.ComandoSolicitudCrearProduct;
import ecommerce.sales.comando.ComandoSolicitudCrearSale;
import ecommerce.sales.comando.manejador.ManejadorCrearSale;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sale")
@Tag(name = "Controlador comando sale")
public class ComandoControladorSale {
    private ManejadorCrearSale manejadorCrearSale;

    public ComandoControladorSale(ManejadorCrearSale manejadorCrearSale) {
        this.manejadorCrearSale = manejadorCrearSale;
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Crear sale", description = "Metodo para crear sale nuevo")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSolicitudCrearSale comandoSolicitudCrearSale){
        return this.manejadorCrearSale.ejecutar(comandoSolicitudCrearSale);
    }
}
