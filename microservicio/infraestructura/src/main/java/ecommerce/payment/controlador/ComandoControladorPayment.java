package ecommerce.payment.controlador;

import ecommerce.ComandoRespuesta;
import ecommerce.payment.comando.ComandoSolicitudCrearPayment;
import ecommerce.payment.comando.manejador.ManejadorCrearPayment;
import ecommerce.payment.consulta.ManejadorObtenerListaPayments;
import ecommerce.payment.consulta.ManejadorObtenerListaPaymentsPorIdSale;
import ecommerce.payment.consulta.ManejadorObtenerPaymentPorId;
import ecommerce.salesproducts.comando.ComandoSolicitudCrearSaleProduct;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@Tag(name = "Controlador comando payment")
public class ComandoControladorPayment {
    private final ManejadorCrearPayment manejadorCrearPayment;

    public ComandoControladorPayment(ManejadorCrearPayment manejadorCrearPayment) {
        this.manejadorCrearPayment = manejadorCrearPayment;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Operation(summary = "Crear pago", description = "Metodo para crear pago nuevo")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSolicitudCrearPayment comandoSolicitudCrearPayment){
        return this.manejadorCrearPayment.ejecutar(comandoSolicitudCrearPayment);
    }
}
