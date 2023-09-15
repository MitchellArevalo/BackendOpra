package ecommerce.saleproducts.controlador;

import ecommerce.ComandoRespuesta;
import ecommerce.sales.comando.ComandoSolicitudCrearSale;
import ecommerce.salesproducts.comando.ComandoSolicitudCrearSaleProduct;
import ecommerce.salesproducts.comando.manejador.ManejadorCrearSaleProduct;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/saleproducts")
@Tag(name = "Controlador comando saleproducts")
public class ComandoControladorSaleProduct {
    private final ManejadorCrearSaleProduct manejadorCrearSaleProduct;

    public ComandoControladorSaleProduct(ManejadorCrearSaleProduct manejadorCrearSaleProduct) {
        this.manejadorCrearSaleProduct = manejadorCrearSaleProduct;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Crear sale", description = "Metodo para crear saleproducts nuevo")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSolicitudCrearSaleProduct comandoSolicitudCrearSaleProduct){
        return this.manejadorCrearSaleProduct.ejecutar(comandoSolicitudCrearSaleProduct);
    }
}
