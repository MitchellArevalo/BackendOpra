package ecommerce.payment.puerto.dao;

import ecommerce.payment.modelo.entidad.Payment;

import java.util.List;

public interface DaoPayment {
    Payment obtenerPaymentPorId(Long id);
    List<Payment> obtenerListadoDePayments();
    List<Payment> obtenerListadoDePaymentsPorIdFactura(Long id);
}
