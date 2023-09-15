package ecommerce.payment.consulta;

import ecommerce.payment.modelo.entidad.Payment;
import ecommerce.payment.puerto.dao.DaoPayment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorObtenerListaPayments {
    private final DaoPayment daoPayment;

    public ManejadorObtenerListaPayments(DaoPayment daoPayment) {
        this.daoPayment = daoPayment;
    }

    public List<Payment> ejecutar(){
        return this.daoPayment.obtenerListadoDePayments();
    }
}
