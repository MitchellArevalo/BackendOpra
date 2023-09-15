package ecommerce.payment.controlador;

import ecommerce.payment.comando.manejador.ManejadorCrearPayment;
import ecommerce.payment.consulta.ManejadorObtenerListaPayments;
import ecommerce.payment.consulta.ManejadorObtenerListaPaymentsPorIdSale;
import ecommerce.payment.consulta.ManejadorObtenerPaymentPorId;
import ecommerce.payment.modelo.entidad.Payment;
import ecommerce.salesproducts.modelo.entidad.SaleProduct;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payment")
@Tag(name = "Controlador consulta payment")
public class ConsultaControladorPayment {

    private final ManejadorObtenerPaymentPorId manejadorObtenerPaymentPorId;
    private final ManejadorObtenerListaPayments manejadorObtenerListaPayments;
    private final ManejadorObtenerListaPaymentsPorIdSale manejadorObtenerListaPaymentsPorIdSale;

    public ConsultaControladorPayment(ManejadorObtenerPaymentPorId manejadorObtenerPaymentPorId, ManejadorObtenerListaPayments manejadorObtenerListaPayments, ManejadorObtenerListaPaymentsPorIdSale manejadorObtenerListaPaymentsPorIdSale) {
        this.manejadorObtenerPaymentPorId = manejadorObtenerPaymentPorId;
        this.manejadorObtenerListaPayments = manejadorObtenerListaPayments;
        this.manejadorObtenerListaPaymentsPorIdSale = manejadorObtenerListaPaymentsPorIdSale;
    }

    @GetMapping()
    @Operation(summary = "Visualizar todos", description = "Metodo utilizado para consultar los datos de los SaleProduct")
    public List<Payment> obtenerListadoPayments(){
        return manejadorObtenerListaPayments.ejecutar();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Visualizar uno", description = "Metodo utilizado para consultar los datos de SaleProduct")
    public Payment obtenerPorId(@PathVariable("id")Long id){
        return this.manejadorObtenerPaymentPorId.ejecutar(id);
    }

}
