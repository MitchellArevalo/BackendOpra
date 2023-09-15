package ecommerce.payment.comando.fabrica;

import ecommerce.payment.comando.ComandoSolicitudCrearPayment;
import ecommerce.payment.modelo.entidad.Payment;
import ecommerce.sales.modelo.entidad.Sale;
import ecommerce.sales.puerto.dao.DaoSale;
import org.springframework.stereotype.Component;

@Component
public class GenerarSolicitudCrearPayment {
    private final DaoSale daoSale;

    public GenerarSolicitudCrearPayment(DaoSale daoSale) {
        this.daoSale = daoSale;
    }

    private Sale obtenerSale(Long id){
        return daoSale.obtenerVentaPorID(id);
    }

    public Payment generar(ComandoSolicitudCrearPayment comandoSolicitudCrearPayment){
        return Payment.crear(obtenerSale(comandoSolicitudCrearPayment.getIdSale()), comandoSolicitudCrearPayment.getPriceToPay());
    }
}
