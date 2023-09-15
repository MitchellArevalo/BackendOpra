package ecommerce.payment.consulta;

import ecommerce.payment.modelo.entidad.Payment;
import ecommerce.payment.puerto.dao.DaoPayment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorObtenerListaPaymentsPorIdSale {
    private final DaoPayment daoPayment;

    public ManejadorObtenerListaPaymentsPorIdSale(DaoPayment daoPayment) {
        this.daoPayment = daoPayment;
    }

    public List<Payment> ejecutar(Long id){
        return this.daoPayment.obtenerListadoDePaymentsPorIdFactura(id);
    }
}
