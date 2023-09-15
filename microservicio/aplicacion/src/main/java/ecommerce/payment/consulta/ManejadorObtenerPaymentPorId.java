package ecommerce.payment.consulta;

import ecommerce.payment.modelo.entidad.Payment;
import ecommerce.payment.puerto.dao.DaoPayment;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerPaymentPorId {
    private final DaoPayment daoPayment;

    public ManejadorObtenerPaymentPorId(DaoPayment daoPayment) {
        this.daoPayment = daoPayment;
    }
    public Payment ejecutar(Long id){
        return this.daoPayment.obtenerPaymentPorId(id);
    }
}
